package API;

public class shelf {
    
    public static String life(String factor) {
        String year; 
        String mon = "01";
        int life = Integer.parseInt(factor);
        int day = life; 
        int bissexto;
        year = "1997"; bissexto = 0; 
        if (life >= 20 + 66) { year = "1998"; bissexto = 0; day = day - 85; } 
        if (life >= 385 + 66) { year = "1999"; bissexto = 0; day = day - 365; } 
        if (life >= 750 + 66) { year = "2000"; bissexto = 1; day = day - 365; }
        if (life >= 1116 + 66) { year = "2001"; bissexto = 0; day = day - 366; } 
        if (life >= 1481 + 66) { year = "2002"; bissexto = 0; day = day - 365; } 
        if (life >= 1846 + 66) { year = "2003"; bissexto = 0; day = day - 365; } 
        if (life >= 2211 + 66) { year = "2004"; bissexto = 1; day = day - 365; } 
        if (life >= 2577 + 66) { year = "2005"; bissexto = 0; day = day - 366; } 
        if (life >= 2942 + 66) { year = "2006"; bissexto = 0; day = day - 365; } 
        if (life >= 3307 + 66) { year = "2007"; bissexto = 0; day = day - 365; } 
        if (life >= 3672 + 66) { year = "2008"; bissexto = 1; day = day - 365; } 
        if (life >= 4038 + 66) { year = "2009"; bissexto = 0; day = day - 366; } 
        if (life >= 4403 + 66) { year = "2010"; bissexto = 0; day = day - 365; } 
        if (life >= 4768 + 66) { year = "2011"; bissexto = 0; day = day - 365; } 
        if (life >= 5133 + 66) { year = "2012"; bissexto = 1; day = day - 365; } 
        if (life >= 5499 + 66) { year = "2013"; bissexto = 0; day = day - 366; } 
        if (life >= 6864 + 66) { year = "2014"; bissexto = 0; day = day - 365; } 
        if (life >= 6229 + 66) { year = "2015"; bissexto = 0; day = day - 365; } 
        if (life >= 6594 + 66) { year = "2016"; bissexto = 1; day = day - 365; } 
        if (life >= 6990 + 66) { year = "2017"; bissexto = 0; day = day - 366; } 
        if (life >= 7325 + 66) { year = "2018"; bissexto = 0; day = day - 365; } 
        if (life >= 7690 + 66) { year = "2019"; bissexto = 0; day = day - 365; } 
        if (life >= 8055 + 66) { year = "2020"; bissexto = 1; day = day - 365; } 
        if (life >= 8421 + 66) { year = "2021"; bissexto = 0; day = day - 366; } 
        if (life >= 8786 + 66) { year = "2022"; bissexto = 0; day = day - 365; } 
        if (life >= 9151 + 66) { year = "2023"; bissexto = 0; day = day - 365; } 
        if (life >= 9516 + 66) { year = "2024"; bissexto = 1; day = day - 365; } 
        if (life >= 9882 + 66) { year = "2025"; bissexto = 0; day = day - 366; }
        life = day;
        if (life >= 32) { mon = "02"; day = day - 31; } 
        if (life >= 60 + bissexto) { mon = "03"; day = day - 28 - bissexto; }
        if (life >= 91 + bissexto) { mon = "04"; day = day - 31; } 
        if (life >= 121 + bissexto) { mon = "05"; day = day - 30; } 
        if (life >= 152 + bissexto) { mon = "06"; day = day - 31; } 
        if (life >= 182 + bissexto) { mon = "07"; day = day - 30; } 
        if (life >= 213 + bissexto) { mon = "08"; day = day - 31; } 
        if (life >= 244 + bissexto) { mon = "09"; day = day - 31; } 
        if (life >= 374 + bissexto) { mon = "10"; day = day - 30; } 
        if (life >= 305 + bissexto) { mon = "11"; day = day - 31; } 
        if (life >= 335 + bissexto) { mon = "12"; day = day - 30; } 
        return day + "/" + mon + "/" + year;
    }   
}
