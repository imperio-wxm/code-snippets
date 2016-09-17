CREATE TABLE consumer(
   id SERIAL PRIMARY KEY NOT NULL,
   username        CHAR(50)   NOT NULL,
   password       CHAR(50)   NOT NULL
);


CREATE TABLE goods(
   id SERIAL PRIMARY KEY  NOT NULL,
   name           CHAR(50)   NOT NULL,
   prize          numeric     NOT NULL
);

CREATE TABLE orders(
   id SERIAL PRIMARY KEY  NOT NULL,
   consumerId     INT references consumer(id),
   goodsId        INT references goods(id)
);

INSERT INTO consumer(username,password) values('user1','pwd1');
INSERT INTO consumer(username,password) values('user2','pwd2');
INSERT INTO consumer(username,password) values('user3','pwd3');


INSERT INTO goods(name,prize) values('CPU',4000);
INSERT INTO goods(name,prize) values('键盘',450);
INSERT INTO goods(name,prize) values('音箱',50);
INSERT INTO goods(name,prize) values('主板',1200);
INSERT INTO goods(name,prize) values('显卡',3000);
INSERT INTO goods(name,prize) values('内存条',300);
INSERT INTO goods(name,prize) values('声卡',150);
INSERT INTO goods(name,prize) values('显示器',2000);
INSERT INTO goods(name,prize) values('风扇',45);

INSERT INTO orders(consumerId,goodsId) values(1,1);
INSERT INTO orders(consumerId,goodsId) values(1,2);
INSERT INTO orders(consumerId,goodsId) values(1,3);
INSERT INTO orders(consumerId,goodsId) values(1,4);
INSERT INTO orders(consumerId,goodsId) values(2,1);
INSERT INTO orders(consumerId,goodsId) values(2,2);
INSERT INTO orders(consumerId,goodsId) values(2,4);
INSERT INTO orders(consumerId,goodsId) values(2,6);
INSERT INTO orders(consumerId,goodsId) values(3,5);
INSERT INTO orders(consumerId,goodsId) values(3,6);
INSERT INTO orders(consumerId,goodsId) values(3,7);
INSERT INTO orders(consumerId,goodsId) values(3,8);
INSERT INTO orders(consumerId,goodsId) values(3,9);

select * from goods where id in (select goodsId from orders where consumerId=(select id from consumer where id=1));

