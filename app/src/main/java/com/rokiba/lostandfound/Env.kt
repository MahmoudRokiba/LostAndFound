package com.rokiba.lostandfound

object Env {

    val isProduction = false

    val PREF_NAME = "LostAndFind"
    val DOMAIN by lazy {
        if (isProduction){
            "https://find.beetleware.com/"
        } else {
            "https://find.beetleware.com/"
        }
    }
    //const val GOOGLE_WEB_CLIENT = "902532031429-hvf97n2kiulrvurm1pufivue58kc79bv.apps.googleusercontent.com"
    //const val BASIC_TOKEN = "Basic cm9raWJhX29hdXRoX2NsaWVudDpyb2tpYmFfb2F1dGhfc2VjcmV0"
    //1kUDQY3EGsm3Bss2RAssITqBGKQmLw2IUZJxS8in
    val FILES_URL = DOMAIN + ""
    val API_URL = DOMAIN + "api/"
    const val pageLimit = "10"
    const val ADDONS = 1
    const val DRINKS = 2
    const val INGREDIENTS = 3

    const val GOOGLE_MAP_KEY = "AIzaSyDFmzjt7BLDE9bZvRXl_ERCwo2EtkqARy8"

    const val OFFER_ACTION_MEAL = "meal"
    const val OFFER_ACTION_RESTAURANT = "single_restaurant"
    const val OFFER_ACTION_RESTAURANTS = "multi_restaurant"

}