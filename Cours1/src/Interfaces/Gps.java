package Interfaces;

public interface Gps {

    public Coordonnees obtenirPosition();

    class Coordonnees {

        private float latitude;
        private float longitude;

        public Coordonnees(float longitude, float latitude) {

            this.longitude = longitude;
            this.latitude = latitude;

        }

        public float getLatitude() {

            return latitude;

        }

        public float getLongitude() {

            return longitude;

        }

        public void setLatitude(float latitude){

            this.latitude = latitude;

        }

    }
}
