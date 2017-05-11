package entity.tbl;

import com.bitbit.bitbit.SqlSliders;
import com.orm.SugarRecord;

/**
 * Created by Javad Ansari on 4/10/2017.
 */

public class tbl_category {
    public class entity {

        public entity() {
        }

        private int id;
        private String parent;
        private int company;
        private int galleryCollectionStatus;
        private int galleryCollectionType;
        private String url;
        private String title;
        private String comment;
        private int sort;
        private String datetimeCreate;
        private String titleGalleryCollectionStatus;
        private String titleGalleryCollectionType;
        private String level;
        private String entGalleryCollectionCategory;
        private String entGalleryItem;


        public entity(int id, String parent, int company, int galleryCollectionStatus, int galleryCollectionType, String url, String title, String comment, int sort, String datetimeCreate, String titleGalleryCollectionStatus, String titleGalleryCollectionType, String level, String entGalleryCollectionCategory, String entGalleryItem) {
            this.id = id;
            this.parent = parent;
            this.company = company;
            this.galleryCollectionStatus = galleryCollectionStatus;
            this.galleryCollectionType = galleryCollectionType;
            this.url = url;
            this.title = title;
            this.comment = comment;
            this.sort = sort;
            this.datetimeCreate = datetimeCreate;
            this.titleGalleryCollectionStatus = titleGalleryCollectionStatus;
            this.titleGalleryCollectionType = titleGalleryCollectionType;
            this.level = level;
            this.entGalleryCollectionCategory = entGalleryCollectionCategory;
            this.entGalleryItem = entGalleryItem;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public int getCompany() {
            return company;
        }

        public void setCompany(int company) {
            this.company = company;
        }

        public int getGalleryCollectionStatus() {
            return galleryCollectionStatus;
        }

        public void setGalleryCollectionStatus(int galleryCollectionStatus) {
            this.galleryCollectionStatus = galleryCollectionStatus;
        }

        public int getGalleryCollectionType() {
            return galleryCollectionType;
        }

        public void setGalleryCollectionType(int galleryCollectionType) {
            this.galleryCollectionType = galleryCollectionType;
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

        public String getDatetimeCreate() {
            return datetimeCreate;
        }

        public void setDatetimeCreate(String datetimeCreate) {
            this.datetimeCreate = datetimeCreate;
        }

        public String getTitleGalleryCollectionStatus() {
            return titleGalleryCollectionStatus;
        }

        public void setTitleGalleryCollectionStatus(String titleGalleryCollectionStatus) {
            this.titleGalleryCollectionStatus = titleGalleryCollectionStatus;
        }

        public String getTitleGalleryCollectionType() {
            return titleGalleryCollectionType;
        }

        public void setTitleGalleryCollectionType(String titleGalleryCollectionType) {
            this.titleGalleryCollectionType = titleGalleryCollectionType;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEntGalleryCollectionCategory() {
            return entGalleryCollectionCategory;
        }

        public void setEntGalleryCollectionCategory(String entGalleryCollectionCategory) {
            this.entGalleryCollectionCategory = entGalleryCollectionCategory;
        }

        public String getEntGalleryItem() {
            return entGalleryItem;
        }

        public void setEntGalleryItem(String entGalleryItem) {
            this.entGalleryItem = entGalleryItem;
        }
    }

    public class post {
        private String searchWord;
        private int skip;
        private int take;

        public post() {
        }


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

    public class entitySql extends SugarRecord {
        private int ii;
        private String parent;
        private int company;
        private int galleryCollectionStatus;
        private int galleryCollectionType;
        private String url;
        private String title;
        private String comment;
        private int sort;
        private String datetimeCreate;
        private String titleGalleryCollectionStatus;
        private String titleGalleryCollectionType;
        private String level;
        private String entGalleryCollectionCategory;
        private String entGalleryItem;

        public entitySql(int ii, String parent, int company, int galleryCollectionStatus, int galleryCollectionType, String url, String title, String comment, int sort, String datetimeCreate, String titleGalleryCollectionStatus, String titleGalleryCollectionType, String level, String entGalleryCollectionCategory, String entGalleryItem) {
            this.ii = ii;
            this.parent = parent;
            this.company = company;
            this.galleryCollectionStatus = galleryCollectionStatus;
            this.galleryCollectionType = galleryCollectionType;
            this.url = url;
            this.title = title;
            this.comment = comment;
            this.sort = sort;
            this.datetimeCreate = datetimeCreate;
            this.titleGalleryCollectionStatus = titleGalleryCollectionStatus;
            this.titleGalleryCollectionType = titleGalleryCollectionType;
            this.level = level;
            this.entGalleryCollectionCategory = entGalleryCollectionCategory;
            this.entGalleryItem = entGalleryItem;
        }

        public int getIi() {
            return ii;
        }

        public void setIi(int ii) {
            this.ii = ii;
        }

        public String getParent() {
            return parent;
        }

        public void setParent(String parent) {
            this.parent = parent;
        }

        public int getCompany() {
            return company;
        }

        public void setCompany(int company) {
            this.company = company;
        }

        public int getGalleryCollectionStatus() {
            return galleryCollectionStatus;
        }

        public void setGalleryCollectionStatus(int galleryCollectionStatus) {
            this.galleryCollectionStatus = galleryCollectionStatus;
        }

        public int getGalleryCollectionType() {
            return galleryCollectionType;
        }

        public void setGalleryCollectionType(int galleryCollectionType) {
            this.galleryCollectionType = galleryCollectionType;
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

        public String getDatetimeCreate() {
            return datetimeCreate;
        }

        public void setDatetimeCreate(String datetimeCreate) {
            this.datetimeCreate = datetimeCreate;
        }

        public String getTitleGalleryCollectionStatus() {
            return titleGalleryCollectionStatus;
        }

        public void setTitleGalleryCollectionStatus(String titleGalleryCollectionStatus) {
            this.titleGalleryCollectionStatus = titleGalleryCollectionStatus;
        }

        public String getTitleGalleryCollectionType() {
            return titleGalleryCollectionType;
        }

        public void setTitleGalleryCollectionType(String titleGalleryCollectionType) {
            this.titleGalleryCollectionType = titleGalleryCollectionType;
        }

        public String getLevel() {
            return level;
        }

        public void setLevel(String level) {
            this.level = level;
        }

        public String getEntGalleryCollectionCategory() {
            return entGalleryCollectionCategory;
        }

        public void setEntGalleryCollectionCategory(String entGalleryCollectionCategory) {
            this.entGalleryCollectionCategory = entGalleryCollectionCategory;
        }

        public String getEntGalleryItem() {
            return entGalleryItem;
        }

        public void setEntGalleryItem(String entGalleryItem) {
            this.entGalleryItem = entGalleryItem;
        }
    }

}

