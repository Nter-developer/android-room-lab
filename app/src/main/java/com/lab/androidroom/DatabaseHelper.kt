package com.lab.androidroom

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.provider.BaseColumns
import android.util.Log

class DatabaseHelper(context: Context) :
    SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {
    override fun onCreate(p0: SQLiteDatabase?) {
        val db = this.writableDatabase
        try {
            db.execSQL(SAMPLE_QUERY_CREATE)
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        } finally {
            db.close()
        }
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {
        // Not yet implemented
    }

    // Execute query except SELECT statement
    fun execSelectQuery(sql: String) {
        val db = this.writableDatabase
        try {
            db.execSQL(sql)
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        } finally {
            db.close()
        }
    }

    // Execute only SELECT statement
    fun execRawQuery(sql: String) {
        val db = this.writableDatabase
        try {
            val cursor = db.rawQuery(sql, null)
            printCursor(cursor)
            cursor.close()
        } catch (e: Exception) {
            Log.e(TAG, "${e.message}")
        } finally {
            db.close()
        }
    }

    private fun printCursor(cursor: Cursor?) {
        cursor?.apply {
            if (moveToFirst()) {
                val columnCount = cursor.columnCount
                do {
                    for (i in 0 until columnCount) {
                        val columnName = cursor.getColumnName(i)
                        val columnsValue = cursor.getString(i)
                        Log.d(TAG, "$columnName: $columnsValue")
                    }
                } while (moveToNext())
            } else {
                Log.d(TAG, "Cursor is empty")
            }
            close()
        }
    }

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "sample.db"

        private const val TAG = "DB_HELPER"
        private const val SAMPLE_QUERY_CREATE =
            """CREATE TABLE SAMPLE (${BaseColumns._ID} INTEGER PRIMARY KEY AUTOINCREMENT, 
                NAME TEXT, LAST_NAME TEXT)"""
    }
}