package entity.tbl;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class tbl_galleryFilter {

    public class entity {
        public entity() {}
        private int galleryCollectionSpecification;
        private int minvalue;
        private int maxvalue;

        public entity(int galleryCollectionSpecification, int minvalue, int maxvalue) {
            this.galleryCollectionSpecification = galleryCollectionSpecification;
            this.minvalue = minvalue;
            this.maxvalue = maxvalue;
        }

        public int getGalleryCollectionSpecification() {
            return galleryCollectionSpecification;
        }

        public void setGalleryCollectionSpecification(int galleryCollectionSpecification) {
            this.galleryCollectionSpecification = galleryCollectionSpecification;
        }

        public int getMinvalue() {
            return minvalue;
        }

        public void setMinvalue(int minvalue) {
            this.minvalue = minvalue;
        }

        public int getMaxvalue() {
            return maxvalue;
        }

        public void setMaxvalue(int maxvalue) {
            this.maxvalue = maxvalue;
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
