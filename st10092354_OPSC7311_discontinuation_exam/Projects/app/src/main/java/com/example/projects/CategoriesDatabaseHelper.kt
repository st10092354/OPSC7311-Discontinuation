package com.example.projects

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class CategoriesDatabaseHelper(context: Context) :SQLiteOpenHelper(context, DATABASE_NAME,null, DATABASE_VERSION) {

    companion object{
        private const val DATABASE_NAME = "category.db"
        private const val DATABASE_VERSION = 1
        private const val TABLE_NAME = "allcategories"
        private const val COLUMN_ID = "id"
        private const val COLUMN_TITLE = "title"
        private const val COLUMN_CONTENT = "content"
    }

    override fun onCreate(db: SQLiteDatabase?) {
       val createTableQuery = "CREATE TABLE $TABLE_NAME ($COLUMN_ID INTEGER PRIMARY KEY, $COLUMN_TITLE TEXT, $COLUMN_CONTENT TEXT)"
        db?.execSQL(createTableQuery)
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        val dropTableQuery = "DROP TABLE IF EXISTS $TABLE_NAME"
        db?.execSQL(dropTableQuery)
        onCreate(db)
    }

    fun insertCategory (Data: Data){
        val db = writableDatabase
        val values = ContentValues().apply {
            put(COLUMN_TITLE, Data.title)
            put(COLUMN_CONTENT, Data.content)
        }
        db.insert(TABLE_NAME, null, values)
        db.close()
    }

    fun getAllCategories(): List<Data>{
        val DataList = mutableListOf<Data>()
        val db = readableDatabase
        val query = "SELECT * FROM $TABLE_NAME"
        val cursor = db.rawQuery(query, null )

        while (cursor.moveToNext()){
            val id = cursor.getInt(cursor.getColumnIndexOrThrow(COLUMN_ID))
            val title = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_TITLE))
            val  content = cursor.getString(cursor.getColumnIndexOrThrow(COLUMN_CONTENT))

            val data = Data(id, title, content)
            DataList.add(data)
        }
        cursor.close()
        db.close()
        return DataList
    }
}