package Response;

import sun.applet.Main;

public class TelloDrone {

        public static String ipAddress;
        public static int port;

        public TelloDrone(String ipAddress, int port){
            this.ipAddress=ipAddress;
            this.port=port;
        }

        public static final String IP_ADDRESS=ipAddress;

        /*
         * Connection UDP Port.
         */
        public static final Integer UDP_PORT = port;
        private Integer battery;
        private Integer speed;
        private String time;
        private TelloConnection telloConnection;
        private TelloMode telloMode;

        public TelloDrone() {
            telloConnection = TelloConnection.CONNECTED;
            telloMode = TelloMode.NORMAL;
        }

        @Override
        public Integer getBattery() {
            return battery;
        }

        @Override
        public void setBattery(Integer battery) {
            this.battery = battery;
        }

        @Override
        public Integer getSpeed() {
            return speed;
        }

        @Override
        public void setSpeed(Integer speed) {
            this.speed = speed;
        }

        @Override
        public String getTime() {
            return time;
        }

        @Override
        public void setTime(String time) {
            this.time = time;
        }

        @Override
        public TelloConnection getTelloConnection() {
            return telloConnection;
        }

        @Override
        public void setTelloConnection(TelloConnection telloConnection) {
            this.telloConnection = telloConnection;
        }

        @Override
        public TelloMode getTelloMode() {
            return telloMode;
        }

        @Override
        public void setTelloMode(TelloMode telloMode) {
            this.telloMode = telloMode;
        }
    }



