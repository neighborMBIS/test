package wj.filechecktest.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by user on 2016-08-29.
 */
public class DBManager {
    private static DBManager ourInstance = null;

    public static DBManager getInstance(Context context) {
        if (ourInstance == null) {
            ourInstance = new DBManager(context);
        }
        return ourInstance;
    }

    Context ctx;

    private SQLiteDatabase mDatabase = null;

    private static final int DATABASE_VERSION = 1;

    private static final String DATABASE_NAME = "MBIS.db";
    private static final String TABLE_NAMER = "Route";
    private static final String TABLE_NAMES = "Station";
    private static final String TABLE_NAMERS = "RouteStation";
    private static final String TABLE_NAMERC = "Config";

    private static final String route_id = "route_id";
    private static final String route_name = "route_name";
    private static final String route_form = "route_form";
    private static final String route_type = "route_type";
    private static final String route_first_start_time = "route_first_start_time";
    private static final String route_last_start_time = "route_last_start_time";
    private static final String route_average_interval = "route_average_interval";
    private static final String route_average_time = "route_average_time";
    private static final String route_length = "route_length";
    private static final String route_station_num = "route_station_num";
    private static final String route_start_station = "route_start_station";
    private static final String route_important_station1 = "route_important_station1";
    private static final String route_important_station2 = "route_important_station2";
    private static final String route_last_station = "route_last_station";


    private static final String station_id = "station_id";
    private static final String station_name = "station_name";
    private static final String station_type = "station_type";
    private static final String station_angle = "station_angle";
    private static final String station_x = "station_x";
    private static final String station_y = "station_y";
    private static final String station_arrive_distance = "station_arrive_distance";
    private static final String station_start_distance = "station_start_distance";


    private static final String station_order = "station_order";
    private static final String station_distance = "station_distance";
    private static final String station_time = "station_time";


    private static final String apply_date = "apply_date";
    private static final String apply_time = "apply_time";
    private static final String apply_file_name = "apply_file_name";
    private static final String apply_table_type = "apply_table_type";
    private static final String updatable = "updatable";


    private DBManager(Context context) {
        ctx = context;
        mDatabase = context.openOrCreateDatabase(DATABASE_NAME, Context.MODE_PRIVATE, null);

        String makeDBConfig = "CREATE TABLE IF NOT EXISTS " + TABLE_NAMERC + " (" +
                "_id integer primary key autoincrement," +
                apply_date + " TEXT," +
                apply_time + " TEXT," +
                apply_file_name + " TEXT, " +
                apply_table_type + " integer, " +
                updatable + " integer " +
                ");";

        String makeDBR = "CREATE TABLE IF NOT EXISTS " + TABLE_NAMER + " (" +
                "_id integer primary key autoincrement," +
                route_id + " TEXT," +
                route_name + " TEXT," +
                route_form + " integer," +
                route_type + " integer," +
                route_first_start_time + " integer," +
                route_last_start_time + " integer," +
                route_average_interval + " integer," +
                route_average_time + " integer," +
                route_length + " integer," +
                route_station_num + " integer," +
                route_start_station + " TEXT," +
                route_important_station1 + " TEXT," +
                route_important_station2 + " TEXT," +
                route_last_station + " TEXT" +
                ");";

        String makeDBS = "CREATE TABLE IF NOT EXISTS " + TABLE_NAMES + " (" +
                "_id integer primary key autoincrement," +
                station_id + " TEXT," +
                station_name + " TEXT," +
                station_type + " integer," +
                station_angle + " integer," +
                station_x + " TEXT," +
                station_y + " TEXT," +
                station_arrive_distance + " integer," +
                station_start_distance + " integer" +
                ");";

        String makeDBRS = "CREATE TABLE IF NOT EXISTS " + TABLE_NAMERS + " (" +
                "_id integer primary key autoincrement," +
                route_id + " TEXT," +
                route_form + " integer," +
                station_id + " TEXT," +
                station_order + " integer," +
                station_distance + " integer," +
                station_time + " integer" +
                ");";



        mDatabase.execSQL(makeDBConfig);
        mDatabase.execSQL(makeDBR);
        mDatabase.execSQL(makeDBS);
        mDatabase.execSQL(makeDBRS);
//        mDatabase.execSQL(makeDBRBuf);
//        mDatabase.execSQL(makeDBSBuf);
//        mDatabase.execSQL(makeDBRSBuf);


    }

    public void insertRoute(ContentValues addRowValue) {
        try {
            mDatabase.beginTransaction();
        mDatabase.insert(TABLE_NAMER, null, addRowValue);
            mDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
        } finally {
            mDatabase.endTransaction();
        }
    }

    public void insertStation(ContentValues addRowValue) {
        try {
            mDatabase.beginTransaction();
        mDatabase.insert(TABLE_NAMES, null, addRowValue);
            mDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
        } finally {
            mDatabase.endTransaction();
        }
    }

    public void insertRouteStation(ContentValues addRowValue) {
        try {
            mDatabase.beginTransaction();
        mDatabase.insert(TABLE_NAMERS, null, addRowValue);
            mDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
        } finally {
            mDatabase.endTransaction();
        }
    }

    public void insertConfig(ContentValues addRowValue) {
        try {
            mDatabase.beginTransaction();
        mDatabase.insert(TABLE_NAMERC, null, addRowValue);
            mDatabase.setTransactionSuccessful();
        } catch (SQLException e) {
        } finally {
            mDatabase.endTransaction();
        }
    }

    public void beginTransaction() {
        mDatabase.beginTransaction();
    }

    public void endTransaction() {
        mDatabase.setTransactionSuccessful();
        mDatabase.endTransaction();
    }

    public Cursor queryRoute(String[] columns,
                             String selection,
                             String[] selectionArgs,
                             String groupBy,
                             String having,
                             String orderBy) {

        return mDatabase.query(TABLE_NAMER,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
    }

    public Cursor queryStation(String[] columns,
                               String selection,
                               String[] selectionArgs,
                               String groupBy,
                               String having,
                               String orderBy) {

        return mDatabase.query(TABLE_NAMES,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
    }

    public Cursor queryRouteStation(String[] columns,
                                    String selection,
                                    String[] selectionArgs,
                                    String groupBy,
                                    String having,
                                    String orderBy) {

        return mDatabase.query(TABLE_NAMERS,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
    }

    public Cursor queryConfig(String[] columns,
                              String selection,
                              String[] selectionArgs,
                              String groupBy,
                              String having,
                              String orderBy) {

        return mDatabase.query(TABLE_NAMERC,
                columns,
                selection,
                selectionArgs,
                groupBy,
                having,
                orderBy);
    }

    public int deleteRoute(String whereClause,
                           String[] whereArgs) {
        return mDatabase.delete(TABLE_NAMER, whereClause, whereArgs);
    }

    public int deleteStation(String whereClause,
                             String[] whereArgs) {
        return mDatabase.delete(TABLE_NAMES, whereClause, whereArgs);
    }

    public int deleteRouteStation(String whereClause,
                                  String[] whereArgs) {
        return mDatabase.delete(TABLE_NAMERS, whereClause, whereArgs);
    }

    public int deleteConfig(String whereClause,
                            String[] whereArgs) {
        return mDatabase.delete(TABLE_NAMERC, whereClause, whereArgs);
    }

}
