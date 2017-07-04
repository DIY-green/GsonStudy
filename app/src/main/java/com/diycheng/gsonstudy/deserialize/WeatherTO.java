package com.diycheng.gsonstudy.deserialize;

/**
 * Created by liwangcheng on 2017/7/4 17:59.
 */

public class WeatherTO {
    // {'status': 'ok','now': {'cond': {'code': '100','txt': '晴'},'fl': '30','hum': '20%','pcpn': '0.0','pres': '1001','tmp': '32','vis': '10','wind': {'deg': '10','dir': '北风','sc': '3级','spd': '15'}}}
    /**
     * status : ok
     * now : {"cond":{"code":"100","txt":"晴"},"fl":"30","hum":"20%","pcpn":"0.0","pres":"1001","tmp":"32","vis":"10","wind":{"deg":"10","dir":"北风","sc":"3级","spd":"15"}}
     */

    private String status;
    private NowBean now;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public NowBean getNow() {
        return now;
    }

    public void setNow(NowBean now) {
        this.now = now;
    }

    public static class NowBean {
        /**
         * cond : {"code":"100","txt":"晴"}
         * fl : 30
         * hum : 20%
         * pcpn : 0.0
         * pres : 1001
         * tmp : 32
         * vis : 10
         * wind : {"deg":"10","dir":"北风","sc":"3级","spd":"15"}
         */

        private CondBean cond;
        private String fl;
        private String hum;
        private String pcpn;
        private String pres;
        private String tmp;
        private String vis;
        private WindBean wind;

        public CondBean getCond() {
            return cond;
        }

        public void setCond(CondBean cond) {
            this.cond = cond;
        }

        public String getFl() {
            return fl;
        }

        public void setFl(String fl) {
            this.fl = fl;
        }

        public String getHum() {
            return hum;
        }

        public void setHum(String hum) {
            this.hum = hum;
        }

        public String getPcpn() {
            return pcpn;
        }

        public void setPcpn(String pcpn) {
            this.pcpn = pcpn;
        }

        public String getPres() {
            return pres;
        }

        public void setPres(String pres) {
            this.pres = pres;
        }

        public String getTmp() {
            return tmp;
        }

        public void setTmp(String tmp) {
            this.tmp = tmp;
        }

        public String getVis() {
            return vis;
        }

        public void setVis(String vis) {
            this.vis = vis;
        }

        public WindBean getWind() {
            return wind;
        }

        public void setWind(WindBean wind) {
            this.wind = wind;
        }

        public static class CondBean {
            /**
             * code : 100
             * txt : 晴
             */

            private String code;
            private String txt;

            public String getCode() {
                return code;
            }

            public void setCode(String code) {
                this.code = code;
            }

            public String getTxt() {
                return txt;
            }

            public void setTxt(String txt) {
                this.txt = txt;
            }

            @Override
            public String toString() {
                return "CondBean{" + '\n' +
                        "code='" + code + '\n' +
                        ", txt='" + txt + '\n' +
                        '}';
            }
        }

        public static class WindBean {
            /**
             * deg : 10
             * dir : 北风
             * sc : 3级
             * spd : 15
             */

            private String deg;
            private String dir;
            private String sc;
            private String spd;

            public String getDeg() {
                return deg;
            }

            public void setDeg(String deg) {
                this.deg = deg;
            }

            public String getDir() {
                return dir;
            }

            public void setDir(String dir) {
                this.dir = dir;
            }

            public String getSc() {
                return sc;
            }

            public void setSc(String sc) {
                this.sc = sc;
            }

            public String getSpd() {
                return spd;
            }

            public void setSpd(String spd) {
                this.spd = spd;
            }

            @Override
            public String toString() {
                return "WindBean{" + '\n' +
                        "deg='" + deg + '\n' +
                        ", dir='" + dir + '\n' +
                        ", sc='" + sc + '\n' +
                        ", spd='" + spd + '\n' +
                        '}';
            }
        }

        @Override
        public String toString() {
            return "NowBean{"  + '\n' +
                    "cond=" + cond + '\n' +
                    ", fl='" + fl + '\n' +
                    ", hum='" + hum + '\n' +
                    ", pcpn='" + pcpn + '\n' +
                    ", pres='" + pres + '\n' +
                    ", tmp='" + tmp + '\n' +
                    ", vis='" + vis + '\n' +
                    ", wind=" + wind + '\n' +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "WeatherTO{" + '\n' +
                "status='" + status + '\n' +
                ", now=" + now + '\n' +
                '}';
    }
}
