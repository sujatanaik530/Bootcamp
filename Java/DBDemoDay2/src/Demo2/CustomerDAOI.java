package Demo2;

public interface CustomerDAOI {
    enum SQL {
        private final String query;
        private SQL(String s) {
            this.query = s;
        }
        public String getQuery() {
            return query;
        }
    }
}
