
![Table flowchart](https://ik.imagekit.io/Flowchart/Let's%20kraack%20_flowchart.png?updatedAt=1757420848316)

# Tracks
| Column     | Type        | Constraints              |
|------------|------------|---------------------------|
| id         | INT / SERIAL | Primary Key             |
| slug       | VARCHAR     | UNIQUE, NOT NULL         |
| title      | VARCHAR     | NOT NULL                 |
| description| TEXT        | —                         |
| isNew      | BOOLEAN     | DEFAULT **true**         |
| isActive   | BOOLEAN     | DEFAULT **true**         |
| createdAt  | DATE        | NOT NULL                 |
| updatedAt  | DATE        | NOT NULL                 |

---

# Jobs
| Column     | Type        | Constraints                |
|------------|-------------|-----------------------------|
| id         | INT / SERIAL | Primary Key               |
| trackId    | INT          | Foreign Key → Tracks(id)   |
| title      | VARCHAR      | NOT NULL                   |
| description| TEXT         | —                           |
| createdAt  | DATE         | NOT NULL                   |
| updatedAt  | DATE         | NOT NULL                   |

---

# Roles
| Column     | Type        | Constraints                |
|------------|-------------|-----------------------------|
| id         | INT / SERIAL | Primary Key               |
| jobId      | INT          | Foreign Key → Jobs(id)     |
| roleName   | VARCHAR      | NOT NULL                   |
| description| TEXT         | —                           |
| createdAt  | DATE         | NOT NULL                   |
| updatedAt  | DATE         | NOT NULL                   |

---

# Courses
| Column     | Type        | Constraints                  |
|------------|-------------|-------------------------------|
| id         | INT / SERIAL | Primary Key                 |
| roleId     | INT          | Foreign Key → Roles(id)     |
| title      | VARCHAR      | NOT NULL                     |
| docsLink   | VARCHAR      | —                             |
| videoLink  | VARCHAR      | —                             |
| difficulty | ENUM('Easy','Medium','Hard') | NOT NULL     |
| createdAt  | DATE         | NOT NULL                     |
| updatedAt  | DATE         | NOT NULL                     |

---

# ProjectIdeas
| Column     | Type        | Constraints                      |
|------------|-------------|-----------------------------------|
| id         | INT / SERIAL | Primary Key                     |
| roleId     | INT          | Foreign Key → Roles(id)         |
| title      | VARCHAR      | NOT NULL                         |
| description| TEXT         | —                                 |
| dependencies | TEXT       | —                                 |
| createdAt  | DATE         | NOT NULL                         |
| updatedAt  | DATE         | NOT NULL                         |

---

# DSA
| Column     | Type        | Constraints                |
|------------|-------------|-----------------------------|
| id         | INT / SERIAL | Primary Key               |
| trackId    | INT          | Foreign Key → Tracks(id)   |
| category   | VARCHAR      | (Pattern, DataStructure)   |
| createdAt  | DATE         | NOT NULL                   |
| updatedAt  | DATE         | NOT NULL                   |

---

# DSA_Subtopics
| Column     | Type        | Constraints                    |
|------------|-------------|---------------------------------|
| id         | INT / SERIAL | Primary Key                   |
| dsaId      | INT          | Foreign Key → DSA(id)         |
| name       | VARCHAR      | (Array, Tree, Graph, etc.)    |
| createdAt  | DATE         | NOT NULL                       |
| updatedAt  | DATE         | NOT NULL                       |

---

# Topics
| Column     | Type        | Constraints                |
|------------|-------------|-----------------------------|
| id         | INT / SERIAL | Primary Key               |
| trackId    | INT          | Foreign Key → Tracks(id)   |
| name       | VARCHAR      | NOT NULL                   |
| createdAt  | DATE         | NOT NULL                   |
| updatedAt  | DATE         | NOT NULL                   |

---

# TopicResources
| Column     | Type        | Constraints                      |
|------------|-------------|-----------------------------------|
| id         | INT / SERIAL | Primary Key                     |
| topicId    | INT          | Foreign Key → Topics(id)        |
| type       | ENUM('Docs','Questions') | NOT NULL            |
| link       | VARCHAR      | —                                 |
| createdAt  | DATE         | NOT NULL                         |
| updatedAt  | DATE         | NOT NULL                         |
