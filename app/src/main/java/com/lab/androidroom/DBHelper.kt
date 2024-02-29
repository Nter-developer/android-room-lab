package com.lab.androidroom

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DBHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

    }

    override fun onUpgrade(db: SQLiteDatabase, newVersion: Int, oldVersion: Int) {

    }

    internal fun execQuery(db: SQLiteDatabase, sql: String) {
        try {
            db.execSQL(sql)
            Log.i(TAG, "SUCCESS")
        } catch (e: Exception) {
            Log.e(TAG, "Error inserting: ${e.message}")
        }
    }


    companion object {
        const val DATABASE_VERSION = 1
        const val DATABASE_NAME = "practice.db"
        private const val TAG = "DB_Helper"
    }
}