package entity.tbl;

import com.orm.SugarRecord;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class tbl_gallery {
    public class entity {

        public entity() {
        }

        private int id;
        private int galleryStatus;
        private int galleryType;
        private int visit;
        private int rate;
        private String url;
        private String title;
        private String summary;
        private String comment;
        private String image;
        private String datetime;


        public entity(int id, int galleryStatus, int galleryType, int visit, int rate, String url, String title, String summary, String comment, String image, String datetime) {
            this.id = id;
            this.galleryStatus = galleryStatus;
            this.galleryType = galleryType;
            this.visit = visit;
            this.rate = rate;
            this.url = url;
            this.title = title;
            this.summary = summary;
            this.comment = comment;
            this.image = image;
            this.datetime = datetime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGalleryStatus() {
            return galleryStatus;
        }

        public void setGalleryStatus(int galleryStatus) {
            this.galleryStatus = galleryStatus;
        }

        public int getGalleryType() {
            return galleryType;
        }

        public void setGalleryType(int galleryType) {
            this.galleryType = galleryType;
        }

        public int getVisit() {
            return visit;
        }

        public void setVisit(int visit) {
            this.visit = visit;
        }

        public int getRate() {
            return rate;
        }

        public void setRate(int rate) {
            this.rate = rate;
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

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }
    }

    public class post {

        private String category;
        private int galleryType;
        private String searchWord;
        private String urlGallery;

        private int skip;
        private int take;

        public post() {
        }

        public post(String category, int galleryType, String searchWord, String urlGallery, int skip, int take) {
            this.category = category;
            this.galleryType = galleryType;
            this.searchWord = searchWord;
            this.urlGallery = urlGallery;
            this.skip = skip;
            this.take = take;
        }


        public String getUrlGallery() {
            return urlGallery;
        }

        public void setUrlGallery(String urlGallery) {
            this.urlGallery = urlGallery;
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public int getGalleryType() {
            return galleryType;
        }

        public void setGalleryType(int galleryType) {
            this.galleryType = galleryType;
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