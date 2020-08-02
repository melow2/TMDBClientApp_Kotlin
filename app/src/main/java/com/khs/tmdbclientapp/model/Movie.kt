package com.khs.tmdbclientapp.model

import android.net.Uri
import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import android.widget.ImageView
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.BindingAdapter
import androidx.databinding.library.baseAdapters.BR
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.khs.tmdbclientapp.R

data class Movie(
    @SerializedName("popularity")
    private var _popularity: Double,
    @SerializedName("id")
    private var _id: Int,
    @SerializedName("video")
    private var _video: Boolean,
    @SerializedName("vote_count")
    private var _voteCount: Int,
    @SerializedName("vote_average")
    private var _voteAverage: Double,
    @SerializedName("title")
    private var _title: String?,
    @SerializedName("release_date")
    private var _releaseDate: String?,
    @SerializedName("original_language")
    private var _originalLanguage: String?,
    @SerializedName("original_title")
    private var _originalTitle: String?,
    @SerializedName("genre_ids")
    private var _genreIds: List<Int?> = listOf(),
    @SerializedName("backdrop_path")
    private var _backdropPath: String?,
    @SerializedName("adult")
    private var _adult: Boolean,
    @SerializedName("overview")
    private var _overview: String?,
    @SerializedName("poster_path")
    private var _posterPath: String?
) : BaseObservable(), Parcelable {
    var voteAverage: String
        @Bindable get() = String.format("%.2f", _voteAverage)
        set(value) {
            _voteAverage = value.toDouble()
            notifyPropertyChanged(BR.voteAverage)
        }

    var voteCount: Int
        @Bindable get() = _voteCount
        set(value) {
            _voteCount = value
            notifyPropertyChanged(BR.voteCount)
        }

    var posterPath: String?
        @Bindable get() = IMAGE_BASE_URL + _posterPath
        set(value) {
            _posterPath = value
            notifyPropertyChanged(BR.posterPath)
        }

    var title:String?
        @Bindable get() = _title
        set(value){
            _title = value
            notifyPropertyChanged(BR.title)
        }

    var originalTitle: String?
        @Bindable get() = _originalTitle
        set(value) {
            _originalTitle = value
            notifyPropertyChanged(BR.originalTitle)
        }

    var releaseDate:String?
        @Bindable get() = _releaseDate
        set(value){
            _releaseDate = value
            notifyPropertyChanged(BR.releaseDate)
        }

    var overview:String?
        @Bindable get() = _overview
        set(value){
            _overview = value
            notifyPropertyChanged(BR.overview)
        }

    constructor(source: Parcel) : this(
        source.readDouble(),
        source.readInt(),
        1 == source.readInt(),
        source.readInt(),
        source.readDouble(),
        source.readString(),
        source.readString(),
        source.readString(),
        source.readString(),
        arrayListOf<Int?>().apply { source.readList(this as List<Int?>, Int::class.java.classLoader) }, // 중요
        source.readString(),
        1 == source.readInt(),
        source.readString(),
        source.readString()
    )

    override fun describeContents() = 0

    override fun writeToParcel(dest: Parcel, flags: Int) = with(dest) {
        writeDouble(_popularity)
        writeInt(_id)
        writeInt((if (_video) 1 else 0))
        writeInt(_voteCount)
        writeDouble(_voteAverage)
        writeString(_title)
        writeString(_releaseDate)
        writeString(_originalLanguage)
        writeString(_originalTitle)
        writeList(_genreIds)
        writeString(_backdropPath)
        writeInt((if (_adult) 1 else 0))
        writeString(_overview)
        writeString(_posterPath)
    }

    companion object {
        private val IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500"

        @BindingAdapter("posterPath")
        @JvmStatic
        fun loadImage(imageView: ImageView?, imageUri: String?) {
            Glide.with(imageView?.context)
                .load(imageUri)
                .placeholder(R.drawable.ic_launcher_background)
                .into(imageView)
        }

        @JvmField
        val CREATOR: Parcelable.Creator<Movie> = object : Parcelable.Creator<Movie> {
            override fun createFromParcel(source: Parcel): Movie = Movie(source)
            override fun newArray(size: Int): Array<Movie?> = arrayOfNulls(size)
        }
    }
}