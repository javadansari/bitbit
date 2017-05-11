package entity.tbl;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Javad Ansari on 4/13/2017.
 */

public class tbl_galleryCollection {

    public class entity {
        public entity() {
        }

        private int id;
        private int employee;
        private int company;
        private int galleryCollection;
        private int galleryCollectionSpecificationStatus;
        private int galleryCollectionSpecificationType;
        private String title;
        private String comment;
        private int list;
        private int sort;
        private String datetimeCreate;
        private String titleGalleryCollectionSpecificationStatus;
        private String titleGalleryCollectionSpecificationType;
        private String entListDeatil;
        private String entVoluDetail;
        private Boolean selectedItem;


        public entity(int id, int employee, int company, int galleryCollection, int galleryCollectionSpecificationStatus, int galleryCollectionSpecificationType, String title, String comment, int list, int sort, String datetimeCreate, String titleGalleryCollectionSpecificationStatus, String titleGalleryCollectionSpecificationType, String entListDeatil, String entVoluDetail, Boolean selectedItem) {
            this.id = id;
            this.employee = employee;
            this.company = company;
            this.galleryCollection = galleryCollection;
            this.galleryCollectionSpecificationStatus = galleryCollectionSpecificationStatus;
            this.galleryCollectionSpecificationType = galleryCollectionSpecificationType;
            this.title = title;
            this.comment = comment;
            this.list = list;
            this.sort = sort;
            this.datetimeCreate = datetimeCreate;
            this.titleGalleryCollectionSpecificationStatus = titleGalleryCollectionSpecificationStatus;
            this.titleGalleryCollectionSpecificationType = titleGalleryCollectionSpecificationType;
            this.entListDeatil = entListDeatil;
            this.entVoluDetail = entVoluDetail;
            this.selectedItem = selectedItem;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getEmployee() {
            return employee;
        }

        public void setEmployee(int employee) {
            this.employee = employee;
        }

        public int getCompany() {
            return company;
        }

        public void setCompany(int company) {
            this.company = company;
        }

        public int getGalleryCollection() {
            return galleryCollection;
        }

        public void setGalleryCollection(int galleryCollection) {
            this.galleryCollection = galleryCollection;
        }

        public int getGalleryCollectionSpecificationStatus() {
            return galleryCollectionSpecificationStatus;
        }

        public void setGalleryCollectionSpecificationStatus(int galleryCollectionSpecificationStatus) {
            this.galleryCollectionSpecificationStatus = galleryCollectionSpecificationStatus;
        }

        public int getGalleryCollectionSpecificationType() {
            return galleryCollectionSpecificationType;
        }

        public void setGalleryCollectionSpecificationType(int galleryCollectionSpecificationType) {
            this.galleryCollectionSpecificationType = galleryCollectionSpecificationType;
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

        public int getList() {
            return list;
        }

        public void setList(int list) {
            this.list = list;
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

        public String getTitleGalleryCollectionSpecificationStatus() {
            return titleGalleryCollectionSpecificationStatus;
        }

        public void setTitleGalleryCollectionSpecificationStatus(String titleGalleryCollectionSpecificationStatus) {
            this.titleGalleryCollectionSpecificationStatus = titleGalleryCollectionSpecificationStatus;
        }

        public String getTitleGalleryCollectionSpecificationType() {
            return titleGalleryCollectionSpecificationType;
        }

        public void setTitleGalleryCollectionSpecificationType(String titleGalleryCollectionSpecificationType) {
            this.titleGalleryCollectionSpecificationType = titleGalleryCollectionSpecificationType;
        }

        public String getEntListDeatil() {
            return entListDeatil;
        }

        public void setEntListDeatil(String entListDeatil) {
            this.entListDeatil = entListDeatil;
        }

        public String getEntVoluDetail() {
            return entVoluDetail;
        }

        public void setEntVoluDetail(String entVoluDetail) {
            this.entVoluDetail = entVoluDetail;
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
