package entity.tbl;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class tbl_galleryCollectionSpecification {

    public class entity {
        public entity() {
        }
        private int id;
        private int list;
        private String title;
        private String comment;
        private int sort;
        private int count;
        private Boolean selectedItem;

        public entity(int id, int list, String title, String comment, int sort, int count, Boolean selectedItem) {
            this.id = id;
            this.list = list;
            this.title = title;
            this.comment = comment;
            this.sort = sort;
            this.count = count;
            this.selectedItem = selectedItem;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getList() {
            return list;
        }

        public void setList(int list) {
            this.list = list;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }

        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }

        public Boolean getSelectedItem() {
            return selectedItem;
        }

        public void setSelectedItem(Boolean selectedItem) {
            this.selectedItem = selectedItem;
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
