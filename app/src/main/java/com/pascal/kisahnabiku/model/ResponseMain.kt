package com.pascal.kisahnabiku.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResponseMain(

	@field:SerializedName("usia")
	val usia: String? = null,

	@field:SerializedName("icon_url")
	val iconUrl: String? = null,

	@field:SerializedName("tmp")
	val tmp: String? = null,

	@field:SerializedName("image_url")
	val imageUrl: String? = null,

	@field:SerializedName("name")
	val name: String? = null,

	@field:SerializedName("thn_kelahiran")
	val thnKelahiran: String? = null,

	@field:SerializedName("description")
	val description: String? = null
) : Parcelable
