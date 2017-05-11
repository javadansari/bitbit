package entity.tbl;

import com.orm.SugarRecord;

/**
 * Created by Javad Ansari on 4/10/2017.
 */

public class tbl_sliders {
    public class entity {

        public entity() {}

        private int type;
        private int id;
        private String url;
        private String title;
        private String summary;
        private String image;

        public entity(int type, int id, String url, String title, String summary, String image) {
            this.type = type;
            this.id = id;
            this.url = url;
            this.title = title;
            this.summary = summary;
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }


        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

    public class post {
        private String searchWord;
        private int skip;
        private int take;

        public post(){}
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

    public class sql extends SugarRecord {


        private int type;
        private int iid;
        private String url;
        private String title;
        private String summary;
        private String image;

        public sql(int type, int iid, String url, String title, String summary, String image) {
            this.type = type;
            this.iid = iid;
            this.url = url;
            this.title = title;
            this.summary = summary;
            this.image = image;
        }

        public int getType() {
            return type;
        }

        public void setType(int type) {
            this.type = type;
        }

        public int getIid() {
            return iid;
        }

        public void setIid(int iid) {
            this.iid = iid;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getSummary() {
            return summary;
        }

        public void setSummary(String summary) {
            this.summary = summary;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }
    }

}
