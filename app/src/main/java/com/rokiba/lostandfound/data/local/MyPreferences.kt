package com.rokiba.lostandfound.data.local

import android.content.SharedPreferences
import com.google.gson.Gson
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@Module
@InstallIn(SingletonComponent::class)
class MyPreferences @Inject constructor(val prefs: SharedPreferences, val gson: Gson) {

    fun delete(key: String) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            remove(key)
            commit()
        }
    }

    fun read(key: String, value: String): String? {
        return prefs.getString(key, value)
    }

    fun read(key: String, value: Long): Long? {
        return prefs.getLong(key, value)
    }

    fun read(key: String, value: Boolean): Boolean {
        return prefs.getBoolean(key, value)
    }

    fun write(key: String, value: String) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putString(key, value)
            commit()
        }
    }

    fun write(key: String, value: Long) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putLong(key, value)
            commit()
        }
    }

    fun write(key: String, value: Boolean) {
        val prefsEditor: SharedPreferences.Editor = prefs.edit()
        with(prefsEditor) {
            putBoolean(key, value)
            commit()
        }
    }

    fun setLat(lang: String){
        write("lat", lang)
    }

    fun getLat(): String{
        return read("lat", "")!!
    }

    fun setLon(lang: String){
        write("lon", lang)
    }

    fun getLon(): String{
        return read("lon", "")!!
    }

    fun setLanguage(lang: String){
        write("lang", lang)
    }

    fun getLanguage(): String{
        return read("lang", "en")!!
    }

    fun setDeviceID(deviceID: String){
        write("deviceID", deviceID)
    }

    fun getDeviceID(): String{
        return read("deviceID", "")!!
    }

    fun setCustPhone(custPhone: String){
        write("custPhone", custPhone)
    }

    fun getCustPhone(): String{
        return read("custPhone", "")!!
    }

    fun setFireBaseToken(lang: String){
        write("fbToken", lang)
    }

    fun getFireBaseToken(): String{
        return read("fbToken", "")!!
    }

    fun setToken(lang: String){
        write("token", lang)
    }

    fun getToken(): String{
        return read("token", "")!!
    }

    fun setLanguageName(lang: String){
        write("langName", lang)
    }

    fun getLanguageName(): String{
        return read("langName", "English")!!
    }




    //Filter Values
    fun setIcuType(icuType: String){
        write("icuType", icuType)
    }

    fun getIcuType(): String{
        return read("icuType", "")!!
    }

    fun setInsuranceCompany(insuranceCompany: String){
        write("insuranceCompany", insuranceCompany)
    }

    fun getInsuranceCompany(): String{
        return read("insuranceCompany", "")!!
    }

    fun setPriceFrom(priceFrom: String){
        write("priceFrom", priceFrom)
    }

    fun getPriceFrom(): String{
        return read("priceFrom", "")!!
    }

    fun setPriceTo(priceTo: String){
        write("priceTo", priceTo)
    }

    fun getPriceTo(): String{
        return read("priceTo", "")!!
    }

    fun setPriceSort(priceSort: String){
        write("priceSort", priceSort)
    }

    fun getPriceSort(): String{
        return read("priceSort", "asc")!!
    }

    fun setDistanceSort(distanceSort: String){
        write("distanceSort", distanceSort)
    }

    fun getDistanceSort(): String{
        return read("distanceSort", "asc")!!
    }

    fun setGender(distanceSort: String){
        write("gender", distanceSort)
    }

    fun getGender(): String{
        return read("gender", "")!!
    }

}