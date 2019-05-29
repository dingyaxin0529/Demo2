package com.jiyun.android_work_1.utils;

import com.jiyun.android_work_1.bean.Bean;
import com.jiyun.android_work_1.dao.BeanDao;
import com.jiyun.android_work_1.dao.DaoMaster;
import com.jiyun.android_work_1.dao.DaoSession;

import java.util.ArrayList;
import java.util.List;

public class MyHelper {

    private final BeanDao beanDao;
    public static MyHelper myHelper;
    public MyHelper() {
        DaoMaster.DevOpenHelper helper = new DaoMaster.DevOpenHelper(MyApp.getMyApp(), "user.db");
        DaoMaster daoMaster = new DaoMaster(helper.getWritableDatabase());
        DaoSession daoSession = daoMaster.newSession();
        beanDao = daoSession.getBeanDao();
    }

    public static MyHelper getMyHelper() {
        if (myHelper==null){
            synchronized (MyHelper.class){
                if (myHelper==null){
                    myHelper=new MyHelper();
                }
            }
        }
        return myHelper;
    }
    public void insertAll(ArrayList<Bean>list){
        if (!has()){
            beanDao.insertOrReplaceInTx(list);
        }
    }
    public void insert(Bean bean){
        beanDao.insertOrReplace(bean);
    }

    public List<Bean>query(){
        return beanDao.queryBuilder().list();
    }
    public boolean has(){
        List<Bean> list = beanDao.queryBuilder().list();
        if (list!=null&&list.size()>0){
            return true;
        }else {
            return false;
        }
    }
}
