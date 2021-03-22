package com.example.aj.myn;

/**
 * Created by aj on 4/5/18.
 */

public class Elements {

        private int id;
        private String name;
        private int percentage;

        //Constructor

        public Elements(int id, String name, int percent) {
            this.id = id;
            this.name = name;
            this.percentage = percent;
        }

        //Setter, getter

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getPercentage() {
            return percentage;
        }

        public void setPercentage(int percent) {
            this.percentage = percent;
        }

    }


