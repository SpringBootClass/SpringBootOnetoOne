DROP DATABASE IF EXISTS empaddressdb;
CREATE DATABASE empaddressdb; /*!40100 DEFAULT CHARACTER SET utf8 */;


DROP TABLE IF EXISTS empaddressdb.employees;
/* EMPLOYEE table */
CREATE TABLE empaddressdb.employees (
    employee_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    employee_firstname VARCHAR(50) NOT NULL DEFAULT '',
    employee_lastname VARCHAR(50) NOT NULL DEFAULT '',
    employee_designation  VARCHAR(50) NOT NULL DEFAULT '',
    employee_salary BIGINT(10) NOT NULL DEFAULT 0,
    employee_phone VARCHAR(15) NOT NULL DEFAULT '',
    PRIMARY KEY (employee_id)
)

ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE empaddressdb.employees AUTO_INCREMENT=1001;


DROP TABLE IF EXISTS empaddressdb.employeeaddresses;
/* EMPLOYEEADDRESS table */
CREATE TABLE empaddressdb.employeeaddresses (
    employee_id BIGINT(20) NOT NULL AUTO_INCREMENT,
    street VARCHAR(50) NOT NULL DEFAULT '',
    city VARCHAR(50) NOT NULL DEFAULT '',
    state VARCHAR(50) NOT NULL DEFAULT '',
    country VARCHAR(50) NOT NULL DEFAULT '',
    PRIMARY KEY (employee_id),
    CONSTRAINT FK_EMP FOREIGN KEY (employee_id) REFERENCES empaddressdb.employees (employee_id)
)

ENGINE=InnoDB DEFAULT CHARSET=utf8;
ALTER TABLE empaddressdb.employeeaddresses AUTO_INCREMENT=1001;

