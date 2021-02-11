package org.example.Model;

public class Absence {
        private int id_absence;
        private String absences;
        private String dateAbsence;
        private String justification;
        private String id_appr;

        public Absence() {

        }

        public Absence(String absences, String dateAbsence, String justification, String id_appr) {
            this.absences = absences;
            this.dateAbsence = dateAbsence;
            this.justification = justification;
            this.id_appr = id_appr;
        }

        public Absence(int id_absence, String absences, String dateAbsence, String justification, String id_appr) {
            this.id_absence = id_absence;
            this.absences = absences;
            this.dateAbsence = dateAbsence;
            this.justification = justification;
            this.id_appr = id_appr;
        }

        public Absence(String absences, String dateAbsence, String justifier, int i) {
                this.absences = absences;
                this.dateAbsence = dateAbsence;
                this.justification = justifier;
                this.id_absence = i;
        }

    public Absence(String text, String text1, String text2, String text3, String id) {
    }


    public int getId_absence() {
            return id_absence;
        }

        public void setId_absence(int id_absence) {
            this.id_absence = id_absence;
        }

        public String getAbsence() {
            return absences;
        }

        public void setAbsence(String absence) {
            this.absences = absences;
        }

        public String getDate() {
            return dateAbsence;
        }

        public void setDate(String date) {
            this.dateAbsence = dateAbsence;
        }

        public String getJustification() {
            return justification;
        }

        public void setJustification(String justification) {
            this.justification = justification;
        }

        public String getId_appr() {
            return id_appr;
        }

        public void setId_appr( String id_appr) {
            this.id_appr = id_appr;
        }
}
