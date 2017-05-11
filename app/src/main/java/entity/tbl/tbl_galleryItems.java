package entity.tbl;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class tbl_galleryItems {
    public class entity {

        public entity() {
        }

        private int id;
        private int gallery;
        private int galleryCollection;
        private int galleryItemStatus;
        private int galleryItemType;
        private int visit;
        private int rate;
        private String url;
        private String title;
        private String summary;
        private String comment;
        private String fileThumb;
        private String fileUpload;
        private String fileSize;
        private String datetime;
        private String datetimeCreate;
        private String description;
        private String titleGalleryCollection;
        private String titleGalleryItemStatus;
        private String titleGalleryItemType;


        public entity(int id, int gallery, int galleryCollection, int galleryItemStatus, int galleryItemType, int visit, int rate, String url, String title, String summary, String comment, String fileThumb, String fileUpload, String fileSize, String datetime, String datetimeCreate, String description, String titleGalleryCollection, String titleGalleryItemStatus, String titleGalleryItemType) {
            this.id = id;
            this.gallery = gallery;
            this.galleryCollection = galleryCollection;
            this.galleryItemStatus = galleryItemStatus;
            this.galleryItemType = galleryItemType;
            this.visit = visit;
            this.rate = rate;
            this.url = url;
            this.title = title;
            this.summary = summary;
            this.comment = comment;
            this.fileThumb = fileThumb;
            this.fileUpload = fileUpload;
            this.fileSize = fileSize;
            this.datetime = datetime;
            this.datetimeCreate = datetimeCreate;
            this.description = description;
            this.titleGalleryCollection = titleGalleryCollection;
            this.titleGalleryItemStatus = titleGalleryItemStatus;
            this.titleGalleryItemType = titleGalleryItemType;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getGallery() {
            return gallery;
        }

        public void setGallery(int gallery) {
            this.gallery = gallery;
        }

        public int getGalleryCollection() {
            return galleryCollection;
        }

        public void setGalleryCollection(int galleryCollection) {
            this.galleryCollection = galleryCollection;
        }

        public int getGalleryItemStatus() {
            return galleryItemStatus;
        }

        public void setGalleryItemStatus(int galleryItemStatus) {
            this.galleryItemStatus = galleryItemStatus;
        }

        public int getGalleryItemType() {
            return galleryItemType;
        }

        public void setGalleryItemType(int galleryItemType) {
            this.galleryItemType = galleryItemType;
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

        public String getFileThumb() {
            return fileThumb;
        }

        public void setFileThumb(String fileThumb) {
            this.fileThumb = fileThumb;
        }

        public String getFileUpload() {
            return fileUpload;
        }

        public void setFileUpload(String fileUpload) {
            this.fileUpload = fileUpload;
        }

        public String getFileSize() {
            return fileSize;
        }

        public void setFileSize(String fileSize) {
            this.fileSize = fileSize;
        }

        public String getDatetime() {
            return datetime;
        }

        public void setDatetime(String datetime) {
            this.datetime = datetime;
        }

        public String getDatetimeCreate() {
            return datetimeCreate;
        }

        public void setDatetimeCreate(String datetimeCreate) {
            this.datetimeCreate = datetimeCreate;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTitleGalleryCollection() {
            return titleGalleryCollection;
        }

        public void setTitleGalleryCollection(String titleGalleryCollection) {
            this.titleGalleryCollection = titleGalleryCollection;
        }

        public String getTitleGalleryItemStatus() {
            return titleGalleryItemStatus;
        }

        public void setTitleGalleryItemStatus(String titleGalleryItemStatus) {
            this.titleGalleryItemStatus = titleGalleryItemStatus;
        }

        public String getTitleGalleryItemType() {
            return titleGalleryItemType;
        }

        public void setTitleGalleryItemType(String titleGalleryItemType) {
            this.titleGalleryItemType = titleGalleryItemType;
        }
    }

    public class post {

        private String category;
        private int galleryType;
        private String searchWord;
        private String galleryCollection;
        private String urlGallery;
        private String galleryCollectionFilterItem;


        private int skip;
        private int take;

        public post() {
        }

        public post(String category, int galleryType, String searchWord, String galleryCollection, String urlGallery, String galleryCollectionFilterItem, int skip, int take) {
            this.category = category;
            this.galleryType = galleryType;
            this.searchWord = searchWord;
            this.galleryCollection = galleryCollection;
            this.urlGallery = urlGallery;
            this.galleryCollectionFilterItem = galleryCollectionFilterItem;
            this.skip = skip;
            this.take = take;
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

        public String getGalleryCollection() {
            return galleryCollection;
        }

        public void setGalleryCollection(String galleryCollection) {
            this.galleryCollection = galleryCollection;
        }

        public String getUrlGallery() {
            return urlGallery;
        }

        public void setUrlGallery(String urlGallery) {
            this.urlGallery = urlGallery;
        }

        public String getGalleryCollectionFilterItem() {
            return galleryCollectionFilterItem;
        }

        public void setGalleryCollectionFilterItem(String galleryCollectionFilterItem) {
            this.galleryCollectionFilterItem = galleryCollectionFilterItem;
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