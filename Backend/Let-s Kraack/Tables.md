# Tracks

| Field       | Data Type    | Constraints      |
|-------------| ------------ |------------------|
| id          | INT / SERIAL | Primary Key      |
| slug        | VARCHAR      | UNIQUE, NOT NULL |
| title       | VARCHAR      | NOT NULL         |
| description | TEXT         | —                |
| isNew       | BOOLEAN      | DEFAULT **true** |
| isActive    | BOOLEAN      | DEFAULT **true** |
| createdAt   | DATE         | NOT NULL         |
| updatedAt   | DATE         | NOT NULL         |
