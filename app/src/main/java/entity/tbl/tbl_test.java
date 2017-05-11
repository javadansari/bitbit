package entity.tbl;

/**
 * Created by Javad Ansari on 3/18/2017.
 */

public class tbl_test {

    public class entity {

        public entity() {}
        private int id;
        private String name;

        public entity(int id, String name) {
            this.id = id;
            this.name = name;
        }

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
    }

    public class post {
        private String searchWord;
        private int skip;
        private int take;

        public post(String searchWord, int skip, int take) {
            this.searchWord = searchWord;
            this.skip = skip;
            this.take = take;
        }

        public String getSearchWord() {
            return searchWord;
        }

        public void setSearchWord(String searchWord) {
            this.searchWord = searchWord;
        }

        public int getSkip() {
            return skip;
        }

        public void setSkip(int skip) {
            this.skip = skip;
        }

        public int getTake() {
            return take;
        }

        public void setTake(int take) {
            this.take = take;
        }
    }
}