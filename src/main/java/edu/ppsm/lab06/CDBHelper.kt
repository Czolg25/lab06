package edu.ppsm.lab06

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import java.sql.SQLException

class CDBHelper: SQLiteOpenHelper{
    val TABLE_TYPE = "TYPES"
    val TYPE_ID = "_id"
    val TYPE_TYPENAME = "typ"
    val TYPE_STANDARD = "norma"

    private val DB_NAME = "Material.db"
    private val DB_VERSION = 1
    private val CREATE_TABLE_TYPE = "CREATE TABLE $TABLE_TYPE("+
            "$TYPE_ID INTEGER PRIMARY KEY AUTOINCREMENT,"+
            " $TYPE_TYPENAME TEXT, $TYPE_STANDARD TEXT)"

    internal constructor(context: Context?) {
        val value = super(context, DB_NAME, null, DB_NAME)
    }

    override fun onCreate(db: SQLiteDatabase?) {
        try {
            db.execSQL(CREATE_TABLE_TYPE)
        }catch (exeption: SQLException){
            Log.i("SQLLite error:",exeption.message!!)
        }
    }

    override fun onUpgrade(db: SQLiteDatabase?, p1: Int, p2: Int) {
        try {
            db.execSQL("DROP TABLE IF EXISTS %s".format(TABLE_TYPE))
            onCreate(db)
        }catch (exeption: SQLException){
            Log.i("SQLLite error:",exeption.message!!)
        }
    }
}