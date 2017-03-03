CREATE DATABASE  IF NOT EXISTS `jpa_onetomany`;
USE `jpa_onetomany`;

--
-- Table structure for table `book_detail`
--

DROP TABLE IF EXISTS `book_category`;
CREATE TABLE `book_category` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`id`,`name`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8;

--
-- Table structure for table `book`
--

DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  `book_category_id` int(11) unsigned DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_book_bookcategoryid_idx` (`book_category_id`),
  CONSTRAINT `fk_book_bookcategoryid` FOREIGN KEY (`book_category_id`) REFERENCES `book_category` (`id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
-------------------------------------------
--my two
use jpa_onetomany;

DROP TABLE IF EXISTS prod_subscription_types;
CREATE TABLE prod_subscription_types
(
    subscription_type_id NUMERIC(38),
    description VARCHAR(255),
    number_of_tracks NUMERIC(5),
    price decimal(13, 2),
    subscription_type VARCHAR(4),
    subscription_enable VARCHAR(1),
    url VARCHAR(150),
    expiration_date_type CHAR(5),
    expiration_date_value VARCHAR(50),
    renewable_indicator CHAR(1),
    subscription_begin_date DATETIME,
    plan_level CHAR(3),
    plan_type CHAR(3),
    priority_order INT DEFAULT 999,
    propick_indicator CHAR(1),
    drf_plus_indicator CHAR(1),
    trial_plan_indicator CHAR(1) DEFAULT "N",
    one_click_eligible_ind CHAR(1) DEFAULT "N",
    drf_plus_type CHAR(3)
);
CREATE UNIQUE INDEX ixunique ON prod_subscription_types (subscription_type_id);


DROP TABLE IF EXISTS drf_subscription_track;
CREATE TABLE drf_subscription_track
(
    subscription_type_id NUMERIC(38) NOT NULL,
    track_id CHAR(3) NOT NULL,
    country CHAR(3) NOT NULL
);
CREATE INDEX ixsubtrkctry ON drf_subscription_track (track_id, country);
CREATE UNIQUE INDEX ixsubtrk ON drf_subscription_track (subscription_type_id, track_id, country);