package com.lab.androidroom

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        // Not yet implemented
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // Not yet implemented
    }

    fun execRawQuery(query: String) {
        if(query.startsWith("SELECT")) {
            execSelectQuery(query)
        } else {
            execNonSelectQuery(query)
        }
    }

    private fun execNonSelectQuery(query: String) {
        val database = this.writableDatabase
        try {
            database.execSQL(query)
            Log.i(TAG, MSG.SUCCESS)
        } catch (e: Exception) {
            Log.e(TAG, MSG.ERROR + "${e.message}")
        } finally {
            database.close()
        }
    }

    private fun execSelectQuery(query: String) {
        val database = this.readableDatabase
        try {
            val cursor = database.rawQuery(query, null)
            Log.i(TAG, MSG.SUCCESS)
            cursor.close()
        } catch (e: Exception) {
            Log.e(TAG, MSG.ERROR + "${e.message}")
        }
    }

    companion object {
        private const val TAG = "DB_HELPER"
        private const val DATABASE_NAME = "practice.db"
        private const val DATABASE_VERSION = 1

        object MSG {
            const val SUCCESS = "Query executed successfully"
            const val ERROR = "Error executing query: "
        }
    }
}