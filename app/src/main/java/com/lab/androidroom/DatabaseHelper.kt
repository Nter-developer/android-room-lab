package com.lab.androidroom

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    override fun onCreate(db: SQLiteDatabase?) {

    }

    override fun onUpgrade(db: SQLiteDatabase?, newVersion: Int, oldVersion: Int) {

    }

    fun execSelectQuery(sql: String) {
        val database = this.writableDatabase
        try {
            val cursor: Cursor? = database.rawQuery(sql, null)
            printCursor(cursor)
            cursor?.close()
        } catch (e: Exception) {
            Log.e(TAG, "ERROR: ${e.message}")
        } finally {
            database.close()
        }
    }

    fun execRawQuery(sql: String) {
        val database = this.writableDatabase
        try {
            database.execSQL(sql, null)

        } catch (e: Exception) {
            Log.e(TAG, "ERROR: ${e.message}")
        } finally {
            database.close()
        }
    }

    private fun printCursor(cursor: Cursor?) {
        cursor?.apply {
            if (moveToFirst()) {
                val columnCount = cursor.columnCount
                do {
                    for (i in 0 until columnCount) {
                        val columnName = cursor.getColumnName(i)
                        val columnValue = cursor.getString(i)
                        Log.d(TAG, "$columnName: $columnValue")
                    }
                } while (moveToNext())
            } else {
                Log.d(TAG, "Cursor is empty.")
            }
            close()
        }
    }

    companion object {
        const val DATABASE_NAME = "practice.db"
        const val DATABASE_VERSION = 1

        private const val TAG = "DB_HELPER"
    }
}