package entity;

/**
 * Created by Javad Ansari on 4/6/2017.
 */

public class Value {
    public class Entity_ServiceValue<T> {


        private Entity_ServiceUser m_User;

        private T m_Data;

        public Entity_ServiceValue(Entity_ServiceUser m_User, T m_Data) {
            this.m_User = m_User;
            this.m_Data = m_Data;
        }

        public Entity_ServiceUser getM_User() {
            return m_User;
        }

        public void setM_User(Entity_ServiceUser m_User) {
            this.m_User = m_User;
        }

        public T getM_Data() {
            return m_Data;
        }

        public void setM_Data(T m_Data) {
            this.m_Data = m_Data;
        }
    }

    public class Entity_ServiceUser {

        private String m_keyAtz;

        private String m_keyUnq;

        public Entity_ServiceUser(String m_keyAtz, String m_keyUnq) {
            this.m_keyAtz = m_keyAtz;
            this.m_keyUnq = m_keyUnq;
        }

        public String getM_keyAtz() {
            return m_keyAtz;
        }

        public void setM_keyAtz(String M_keyAtz) {
            this.m_keyAtz = M_keyAtz;
        }

        public String getM_keyUnq() {
            return m_keyUnq;
        }

        public void setM_keyUnq(String m_keyUnq) {
            this.m_keyUnq = m_keyUnq;
        }

        //  Default to Fail status
        public Entity_ServiceUser() {
            m_keyAtz = null;
            m_keyUnq = null;

        }


    }
}
