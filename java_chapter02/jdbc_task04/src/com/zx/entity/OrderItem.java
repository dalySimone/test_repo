package com.zx.entity;

//    `itemid` varchar(32) NOT NULL,
//    `pid` varchar(32) DEFAULT NULL,
//    `oid` varchar(32) DEFAULT NULL
public class OrderItem {

        private String itemid; //订单项的id
        private String pid; // 外键 指向商品表的主键
        private String oid; // 外键 指向订单表的主键
        private Product product; // 订单项的商品信息
        private Orders orders; // 订单项属于哪个订单

        public String getItemid() {
                return itemid;
        }

        public void setItemid(String itemid) {
                this.itemid = itemid;
        }

        public String getPid() {
                return pid;
        }

        public void setPid(String pid) {
                this.pid = pid;
        }

        public String getOid() {
                return oid;
        }

        public void setOid(String oid) {
                this.oid = oid;
        }

        public Product getProduct() {
                return product;
        }

        public void setProduct(Product product) {
                this.product = product;
        }

        public Orders getOrders() {
                return orders;
        }

        public void setOrders(Orders orders) {
                this.orders = orders;
        }

        @Override
        public String toString() {
                return "OrderItem{" +
                        "itemid='" + itemid + '\'' +
                        ", pid='" + pid + '\'' +
                        ", oid='" + oid + '\'' +
                        '}';
        }
}
