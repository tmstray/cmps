package com.hx.dao;

import com.hx.config.AccessConfig;
import com.hx.config.Constants;
import com.hx.entity.CementLastcount;
import com.hx.entity.CementStrength;
import com.hx.entity.MainData;
import com.hx.utils.DbUtil;
import com.hx.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.*;

@Repository
public class AccessDao {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    AccessConfig accessConfig;
    @Autowired
    CementLastcountMapper cementLastcountMapper;



    public List<CementStrength> resolverMdb() throws Exception{
        Connection conn = null;
        try {
            Class.forName(accessConfig.getDriver());
            Properties properties = new Properties();
            properties.put("charSet",accessConfig.getCharSet());
            properties.put("password",accessConfig.getPassword());
            conn = DriverManager.getConnection("jdbc:Access:///" + accessConfig.getPath(), properties);
            logger.debug("connection: " + conn);
            PreparedStatement statement = conn.prepareStatement(accessConfig.getSql());
            statement.setInt(1,(int)cementLastcountMapper.getLastCount().getCementcount());
            ResultSet result = statement.executeQuery();
            return packData(result);
        }catch (Exception e){
            logger.error("数据库连接出错...",e);
            throw e;
        }finally {
            try {
                if(conn!=null){
                    conn.close();
                }
            }catch (Exception e){
                logger.error("连接关闭出错...",e);
            }

        }

    }

    public List<CementStrength> packData(ResultSet result) throws Exception{
        List<CementStrength> entityList = new ArrayList<>();
        CementStrength tempData = null;
        while (result.next()){
            tempData = new CementStrength();
            tempData.setSampleID(result.getInt("ID"));
            tempData.setSampleNo(result.getString("实验编号"));
            tempData.setKind(result.getString("品种"));
            tempData.setSampleTime(result.getString("实验时间"));
            tempData.setShapeTime(result.getString("成型时间"));
            tempData.setDestructTime(result.getString("破型时间"));
            tempData.setDuration(result.getString("期龄"));
            tempData.setHour(result.getString("小时"));
            tempData.setTemperature(result.getString("室温"));
            tempData.setExperimentStand(result.getString("实验标准"));
            tempData.setStressType(result.getString("抗压型号"));
            tempData.setFlexureType(result.getString("抗折型号"));
            tempData.setStressNo(result.getString("抗压编号"));
            tempData.setFlexureNo(result.getString("抗折编号"));
            tempData.setStressSta(result.getString("抗压状况"));
            tempData.setFlexureSta(result.getString("抗折状况"));
            tempData.setStressSta(result.getString("抗压校核"));
            tempData.setFlexureVail(result.getString("抗折校核"));
            tempData.setStressCKS(result.getString("抗压检验"));
            tempData.setFlexureCKS(result.getString("抗折检验"));
            tempData.setNotes(result.getString("备注"));
            tempData.setStress1(result.getString("压力1"));
            tempData.setStress2(result.getString("压力2"));
            tempData.setStress3(result.getString("压力3"));
            tempData.setStress4(result.getString("压力4"));
            tempData.setStress5(result.getString("压力5"));
            tempData.setStress6(result.getString("压力6"));
            tempData.setPressure1(result.getString("压强1"));
            tempData.setPressure2(result.getString("压强2"));
            tempData.setPressure3(result.getString("压强3"));
            tempData.setPressure4(result.getString("压强4"));
            tempData.setPressure5(result.getString("压强5"));
            tempData.setPressure6(result.getString("压强6"));
            tempData.setAvgPressure(result.getString("平均抗压强度"));
            tempData.setFlexure1(result.getString("抗折1"));
            tempData.setFlexure2(result.getString("抗折2"));
            tempData.setFlexure3(result.getString("抗折3"));
            tempData.setAvgFlexure(result.getString("平均抗折强度"));
            entityList.add(tempData);
        }
        return entityList;
    }


    public boolean createFile(CementStrength cementStrength) throws Exception{
        String flag = cementStrength.getDuration();
        String [] coun1 ={
                "FS1"+flag+":Flexure1","FS2"+flag+":Flexure2","FS3"+flag+":Flexure3",
                "CS1"+flag+":Pressure1","CS2"+flag+":Pressure2","CS3"+flag+":Pressure3",
                "CS4"+flag+":Pressure4","CS5"+flag+":Pressure5","CS6"+flag+":Pressure6"};
        Map<String,String> map = new HashMap<>();
       // map.put("SampleNo",cementStrength.getSampleNo());
       // map.put("SampleTime",cementStrength.getSampleTime());
       // map.put("Kind",cementStrength.getKind());

     //   map.put("ShapeTime",StringUtil.formatString(cementStrength.getShapeTime()));
      //  map.put("DestructTime",StringUtil.formatString(cementStrength.getDestructTime()));
       // map.put("Duration",cementStrength.getDuration());
        map.put("Flexure1",cementStrength.getFlexure1());
        map.put("Flexure2",cementStrength.getFlexure2());
        map.put("Flexure3",cementStrength.getFlexure3());
       // map.put("AvgFlexure",cementStrength.getAvgFlexure());
        map.put("Pressure1",cementStrength.getPressure1());
        map.put("Pressure2",cementStrength.getPressure2());
        map.put("Pressure3",cementStrength.getPressure3());
        map.put("Pressure4",cementStrength.getPressure4());
        map.put("Pressure5",cementStrength.getPressure5());
        map.put("Pressure6",cementStrength.getPressure6());
       // map.put("AvgPressure",cementStrength.getAvgPressure());

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
        String newtime = sdf.format(date);
        String subtime = newtime.substring(2);

        BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(accessConfig.getFilePath() +"\\" +cementStrength.getSampleNo()+"D"+cementStrength.getDuration()+".qan"));
        //输出第一行
        bf.write(rightFormatStr("S",2).getBytes());
        bf.write(rightFormatStr(cementStrength.getSampleNo(),41).getBytes());
     //   bf.write(subtime.getBytes());
        bf.write("\r\n".getBytes());
        //输出第一行结束
        //输出第二行
        bf.write(rightFormatStr("D",2).getBytes());
        bf.write(rightFormatStr("9",2).getBytes());
        bf.write(rightFormatStr(" D"+flag+"FS&CS",10).getBytes());
        bf.write(rightFormatStr("9000",20).getBytes());
       // bf.write(rightFormatStr("10.00",7).getBytes());
       // bf.write("10.20".getBytes());
        bf.write("\r\n".getBytes());
        //输出第二行结束
        //部分循环输出
        writeStr(map,coun1,bf);
        bf.flush();
        bf.close();
        return true;
    }

    private void writeStr(Map<String, String> map, String[] str, BufferedOutputStream bf) {
        String c1 = null;
        String c2 = null;
        StringBuffer strb3 = null;
        for (int i = 0; i < str.length; i++) {
            c1 = str[i].contains(":") ? (str[i].split(":"))[0]:str[i];
            c2 = str[i].contains(":") ? (str[i].split(":"))[1]:str[i];
            strb3 = new StringBuffer();
            strb3.append(rightFormatStr("C",2));
            strb3.append(rightFormatStr(c1,6));
            strb3.append(formatStr(map.get(c2) == null ? "" : map.get(c2),8));
           // strb3.append(rightFormatStr(map.get(c2) == null ? "" : map.get(c2),15));
            strb3.append("\t");
            if("Had".equals(c1)){
                strb3.append(rightFormatStr(" ", 5));
            }else{
                strb3.append(rightFormatStr("%", 5));
            }
            //strb3.append(rightFormatStr("%",5));
            strb3.append(rightFormatStr(c1,36));
            strb3.append(rightFormatStr("8000",4));
            byte [] bs = strb3.toString().getBytes();
            try {
                bf.write(bs);
                bf.write("\r\n".getBytes());
            } catch (IOException e) {
                logger.error("系统错误",e);
            }
        }
    }

    //按指定长度格式化字符串位数不足在前面补空格
    public String formatStr(String str, int length) {
        int strLen;
        if (str == null) {
            strLen = 0;
        }else{
            strLen= str.length();
        }

        if (strLen == length) {
            return str;
        } else if (strLen < length) {
            int temp = length - strLen;
            String tem = "";
            for (int i = 0; i < temp; i++) {
                tem = tem + " ";
            }
            return  tem+str;
        }else{
            return str.substring(0,length);
        }
    }

    //按指定长度格式化字符串位数不足在后面补空格
    public String rightFormatStr(String str, int length) {
        int strLen;
        if (str == null || "null".equals(str)) {
            strLen = 0;
        }else{
            strLen= str.length();
        }

        if (strLen == length) {
            return str;
        } else if (strLen < length) {
            int temp = length - strLen;
            String tem = "";
            for (int i = 0; i < temp; i++) {
                tem = tem + " ";
            }
            return  str + tem;
        }else{
            return str.substring(0,length);
        }
    }


    /**
     * ######################################
     *
     *
     */

    public List<MainData> resolverMdb(HashMap<String, Object> map) throws Exception {
        if (map.get("mdbPath") == null || map.get("sql") == null) {
            //throw new Exception("mdb文件路径不能为空或者SQL语句不能为空");
            return null;
        }
        Connection conn = null;
        try {
            conn = DbUtil.getConnection((String)map.get("mdbPath"), (String)map.get("password"));
            logger.debug("connection: " + conn);
            PreparedStatement statement = conn.prepareStatement((String)map.get("sql"));
            statement.setInt(1, (int) map.get("condition"));
            ResultSet result = statement.executeQuery();
            int tableFlag = (int) map.get("tableFlag");
            return packData(tableFlag, result);
        }catch (Exception e){
            logger.error("数据库连接出错...",e);
            throw e;
        }finally {
            try {
                if(conn != null){
                    conn.close();
                }
            }catch (Exception e){
                logger.error("连接关闭出错...",e);
            }
        }
    }

    public List<MainData> packData(int tableFlag, ResultSet result) throws Exception {
        List<MainData> entityList = new ArrayList<>();
        MainData tempData = null;
        while (result.next()) {
            tempData = new MainData();
            switch (tableFlag) {
                case 1:
                    tempData.setGid(result.getInt("Id"));
                    tempData.setSamplenog(result.getString("SampleId"));
                    tempData.setDrags(result.getString("Drags"));
                    tempData.setMar(result.getString("Mar"));
                    tempData.setMad(result.getString("Mad"));
                    tempData.setVad(result.getString("Vad"));
                    tempData.setAad(result.getString("Aad"));
                    tempData.setHad(result.getString("Had"));
                    tempData.setCreatetimeg(result.getDate("regtime").toString());
                    tempData.setKeed(Constants.getCoalType(result.getString("Keed")));
                    break;
                case 2:
                    tempData.setYid(result.getInt("ID"));
                    tempData.setSamplenoy(result.getString("S_NO"));
                    tempData.setStad(result.getDouble("Stad"));
                    break;
                case 3:
                    tempData.setLid(result.getInt("序号"));
                    tempData.setSamplenol(result.getString("试样编号"));
                    tempData.setQbad(result.getDouble("弹筒发热量"));
                    break;
                default:break;
            }
            entityList.add(tempData);
        }
        return entityList;
    }

    //计算并生成文件
    public boolean createFile(MainData mainData, boolean simpled) throws Exception{
        String [] coun1 ={"Dr:Drags","Mar","Mad","Vad","Aad","Had"};
        Map<String,String> gmap = new HashMap<>();
        gmap.put("Drags",mainData.getDrags());
        gmap.put("Mar", mainData.getMar());
        gmap.put("Mad", mainData.getMad());
        gmap.put("Vad", mainData.getVad());
        gmap.put("Aad", mainData.getAad());
        gmap.put("Had", mainData.getHad());

        String [] coun2={"Sad:Stad"};
        Map<String,String> ymap = new HashMap<>();
        ymap.put("Stad",mainData.getStad() == null ? "" : mainData.getStad().toString());

        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmSSS");
        String newtime = sdf.format(date);
        String subtime = newtime.substring(2);
        //BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(accessConfig.getFilePath() +"\\" +"LG"+subtime+".qan"));
        BufferedOutputStream bf = new BufferedOutputStream(new FileOutputStream(accessConfig.getFilePath() +"\\" +mainData.getSamplenog()+".qan"));
        //输出第一行
        bf.write(rightFormatStr("S",2).getBytes());
        bf.write(rightFormatStr(mainData.getSamplenog(),41).getBytes());
        bf.write(subtime.getBytes());
        bf.write("\r\n".getBytes());
        //输出第一行结束
        //输出第二行
        bf.write(rightFormatStr("D",2).getBytes());
        if(simpled){
            if(mainData.getMar() == null || mainData.getMar().trim().equals("")){
                bf.write(rightFormatStr("7",2).getBytes());
            }else{
                bf.write(rightFormatStr("9",2).getBytes());
            }
        }else{
            bf.write(rightFormatStr("12",3).getBytes());
        }
        bf.write(rightFormatStr("Autocoal",10).getBytes());
        bf.write(rightFormatStr("9000",20).getBytes());
        bf.write(rightFormatStr("10.00",7).getBytes());
        bf.write("10.20".getBytes());
        bf.write("\r\n".getBytes());
        //输出第二行结束
        //部分循环输出
        writeStr(gmap, coun1,bf,simpled);
        //输出fcad计算行
        bf.write(rightFormatStr("C",2).getBytes());
        bf.write(rightFormatStr("Fad",5).getBytes());

        double Vad = mainData.getVad() == null ? 0 : Double.parseDouble(mainData.getVad());
        double Mad = mainData.getMad() == null ? 0 : Double.parseDouble(mainData.getMad());
        double Aad = mainData.getAad() == null ? 0 : Double.parseDouble(mainData.getAad());
        //double Had = mainData.getHad() == null ? 0 : Double.parseDouble(mainData.getHad());
        //double Mar = mainData.getMar() == null ? 0 : Double.parseDouble(mainData.getMar());
        //double Stad = mainData.getStad() == null ? 0 : Double.parseDouble(mainData.getStad().toString());

        //double fcad = (100-Aad-Mad-Vad);
        bf.write(formatStr(mainData.getFcad(),8).getBytes());
        bf.write("\t".getBytes());
        bf.write(rightFormatStr("%",5).getBytes());
        bf.write(rightFormatStr("Fcad",40).getBytes());
        bf.write(rightFormatStr("8000",4).getBytes());
        bf.write("\r\n".getBytes());
        //部分循环输出
        writeStr(ymap, coun2,bf,simpled);
        if(!simpled) {
            //弹筒发热量行输出qbad
            bf.write(rightFormatStr("C", 2).getBytes());
            bf.write(rightFormatStr("Qbd", 5).getBytes());
            String qbad = mainData.getQbad().toString();
            bf.write(formatStr(qbad, 8).getBytes());
            bf.write("\t".getBytes());
            bf.write(rightFormatStr("MJ/kg", 11).getBytes());
            bf.write(rightFormatStr("Qbad", 34).getBytes());
            bf.write(rightFormatStr("8000", 4).getBytes());
            bf.write("\r\n".getBytes());
        }
        //qbad输出结束
        /*double Qbad = Double.parseDouble(qbad);
        double a = 0;
        if (Qbad<=16.7 ){
            a = 0.001;
        }else if (Qbad>16.7 && Qbad<=25.1){
            a = 0.0012;
        }else if (Qbad>=25.1){
            a = 0.0016;
        }
        double Qgrad =  (Qbad * 1000) - (94.1 * Stad)- (a * Qbad * 1000);
        System.out.println(Qgrad);*/
        //double Qgrd = (Qgrad * (100 / (100 - Mad))) / 4.1816;
        //double Qnetad = ((Qgrad - (206 * Had)) -(23 * Mad))/4.1816;
        //double Qnetar = ((Qgrad - (206 * Had)) * ((100 - Mar) / (100 - Mad)) - (23 * Mar))/4.1816;
        //计算行输出
        if(mainData.getMar() != null && !(mainData.getMar().trim().equals(""))) {
            bf.write(rightFormatStr("C", 2).getBytes());
            bf.write(rightFormatStr("Qnr", 5).getBytes());
            bf.write(formatStr(String.format("%.2f", Double.parseDouble(mainData.getQnetar())), 8).getBytes());
            bf.write("\t".getBytes());
            //bf.write(rightFormatStr("kcal/kg",11).getBytes());
            bf.write(rightFormatStr("", 5).getBytes());
            bf.write(rightFormatStr("Qnetar", 40).getBytes());
            bf.write(rightFormatStr("8000", 4).getBytes());
            bf.write("\r\n".getBytes());
        }
        bf.write(rightFormatStr("C",2).getBytes());
        bf.write(rightFormatStr("Qnd",5).getBytes());
        bf.write(formatStr(String.format("%.2f",Double.parseDouble(mainData.getQnetad())),8).getBytes());
        bf.write("\t".getBytes());
        //bf.write(rightFormatStr("kcal/kg",11).getBytes());
        bf.write(rightFormatStr("",5).getBytes());
        bf.write(rightFormatStr("Qnetad",40).getBytes());
        bf.write(rightFormatStr("8000",4).getBytes());
        if(!simpled) {
            bf.write("\r\n".getBytes());
            bf.write(rightFormatStr("C",2).getBytes());
            bf.write(rightFormatStr("Qrd",5).getBytes());
            bf.write(formatStr(String.format("%.2f",Double.parseDouble(mainData.getQgrd())),8).getBytes());
            bf.write("\t".getBytes());
            //bf.write(rightFormatStr("kcal/kg", 11).getBytes());
            bf.write(rightFormatStr("",5).getBytes());
            bf.write(rightFormatStr("Qgrd", 40).getBytes());
            bf.write(rightFormatStr("8000", 4).getBytes());
        }
        bf.flush();
        bf.close();
        return true;
    }

//    private String formatStr(String str, int length) {
//        int strLen;
//        if (str == null) {
//            strLen = 0;
//        }else{
//            strLen= str.length();
//        }
//
//        if (strLen == length) {
//            return str;
//        } else if (strLen < length) {
//            int temp = length - strLen;
//            String tem = "";
//            for (int i = 0; i < temp; i++) {
//                tem = tem + " ";
//            }
//            return  tem+str;
//        }else{
//            return str.substring(0,length);
//        }
//    }
//
//    //按指定长度格式化字符串位数不足在后面补空格
//    private String rightFormatStr(String str, int length) {
//        int strLen;
//        if (str == null || "null".equals(str)) {
//            strLen = 0;
//        }else{
//            strLen= str.length();
//        }
//
//        if (strLen == length) {
//            return str;
//        } else if (strLen < length) {
//            int temp = length - strLen;
//            String tem = "";
//            for (int i = 0; i < temp; i++) {
//                tem = tem + " ";
//            }
//            return  str + tem;
//        }else{
//            return str.substring(0,length);
//        }
//    }

    private void writeStr(Map<String,String> map,String [] str,BufferedOutputStream bf, boolean simpled){
        String c1 = null;
        String c2 = null;
        StringBuffer strb3 = null;
        for (int i = 0; i < str.length; i++) {
            c1 = str[i].contains(":") ? (str[i].split(":"))[0]:str[i];
            c2 = str[i].contains(":") ? (str[i].split(":"))[1]:str[i];
            if("Had".equals(c1) && simpled){
                continue;
            }
            //mar为空时生成文件中不包含mar行
            if("Mar".equals(c1) && simpled && (map.get(c2) == null || map.get(c2).trim().equals(""))){
                continue;
            }
            strb3 = new StringBuffer();
            strb3.append(rightFormatStr("C",2));
            strb3.append(rightFormatStr(c1,5));
            strb3.append(formatStr(map.get(c2) == null ? "" : map.get(c2),8));
            strb3.append("\t");
            if("Had".equals(c1)){
                strb3.append(rightFormatStr(" ", 5));
            }else{
                strb3.append(rightFormatStr("%", 5));
            }
            //strb3.append(rightFormatStr("%",5));
            strb3.append(rightFormatStr(c2,40));
            strb3.append(rightFormatStr("8000",4));
            byte [] bs = strb3.toString().getBytes();
            try {
                bf.write(bs);
                bf.write("\r\n".getBytes());
            } catch (IOException e) {
                logger.error("系统错误",e);
            }
        }
    }
}
