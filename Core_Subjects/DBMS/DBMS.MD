# Chapter 1

### Data

- **Definition:** Characteristics or attributes, either qualitative (descriptive) or quantitative (numerical), collected through observation. Any facts and figures about an entity are termed as data.
- **Importance:** Facilitates analysis, supports decision-making, and is fundamental to research.

### Information

- **Definition:** Data becomes information when analyzed and placed in context, providing a basis for understanding and decision-making.

### Database

- **Definition:** A structured collection of data that enables easy access, management, and updates, typically stored electronically in computer systems.

### Database Management System (DBMS)

- **Definition:** Software that facilitates efficient data storage, retrieval, and management in databases.
- **Functions:**
  - Ensures data safety, integrity, accessibility, and concurrency control.
  - Supports data querying, reporting, and analytics for informed decision-making.

---

### Difference between File System and DBMS

| **Aspect**            | **File System**                                         | **DBMS**                                          |
| --------------------------- | ------------------------------------------------------------- | ------------------------------------------------------- |
| **Data Access**       | Slower due to unstructured querying                           | Structured querying for quicker access                  |
| **Data Isolation**    | Challenges in correlating data across files                   | Facilitates data integration, reducing isolation issues |
| **Data Integrity**    | Risk of inadvertent alterations                               | Features to prevent unauthorized alterations            |
| **Atomicity**         | Potential inconsistency due to incomplete operations          | Supports transaction properties like atomicity          |
| **Concurrent Access** | Conflicts and inconsistencies with simultaneous modifications | Advanced concurrency control for multiple users         |

---

### Data Abstraction Levels in DBMS

| **Level**    | **Description**                                                             |
| ------------------ | --------------------------------------------------------------------------------- |
| **Physical** | Lowest level, manages data storage on hardware, handled by DB administrator.      |
| **Logical**  | Middle level, represents data as entity sets and relationships.                   |
| **View**     | Highest level, displays only portions of the database relevant to user interests. |

---

### Data Independence

- **Physical Data Independence:** The ability to modify internal schema without affecting the conceptual schema (e.g., reorganizing files, modifying indexes).
- **Logical Data Independence:** The ability to change the conceptual schema without altering external schemas or application programs (e.g., adding/removing entities).

---

### Instance vs. Schema

| **Aspect**   | **Description**                                                    |
| ------------------ | ------------------------------------------------------------------------ |
| **Instance** | Collection of data in the database at a specific moment (snapshot).      |
| **Schema**   | Overall design of the database, defining its structure and organization. |

---

### OLAP vs. OLTP

| **Aspect**           | **OLAP (Online Analytical Processing)**  | **OLTP (Online Transaction Processing)** |
| -------------------------- | ---------------------------------------------- | ---------------------------------------------- |
| **Primary Function** | Complex data analysis and reporting            | Handles daily transactional data processing    |
| **Database Design**  | Star or snowflake schema for read optimization | Normalized schema for write optimization       |
| **Query Complexity** | Complex queries with aggregations              | Simple CRUD operations                         |
| **Data Volume**      | Large volumes for historical analysis          | High number of small transactions              |
| **Response Time**    | Slower due to complex queries                  | Fast to support high transaction rates         |

---

### Types of Databases

| **Type**                  | **Description**                                                     | **Example**                                         |
| ------------------------------- | ------------------------------------------------------------------------- | --------------------------------------------------------- |
| **Commercial Database**   | Used in business for handling large transactions and customer data        | Salesforce (CRM system)                                   |
| **Multimedia Database**   | Stores images, audio, and video for managing multimedia content           | Adobe Experience Manager                                  |
| **Deductive Database**    | Uses logic programming for complex, analytical queries                    | Datalog-based systems                                     |
| **Temporal Database**     | Tracks changing data over time for time-based queries                     | Historical trading databases (e.g., stock price tracking) |
| **Geographical Database** | Organizes and analyzes geographical data for spatial analysis and mapping | ArcGIS (GIS system)                                       |

---

### Roles of Database Administrator (DBA)

- **Schema Definition:** Outlines the original database schema.
- **Storage Structure and Access Method Definition:** Defines appropriate storage structures and access methods.
- **Schema/Physical Organization Modification:** Alters schema or physical organization when needed.
- **Authorization Granting:** Manages data access permissions for different users.
- **Integrity Constraints:** Maintains data accuracy and consistency.

---

### DBMS Architecture Components

| **Component**       | **Sub-components/Functions**                                                          |
| ------------------------- | ------------------------------------------------------------------------------------------- |
| **Query Processor** | DML Compiler, DDL Interpreter, Embedded DML Pre-compiler, Query Optimizer                   |
| **Storage Manager** | Authorization Manager, Integrity Manager, Transaction Manager, File Manager, Buffer Manager |
| **Disk Storage**    | Data Files, Data Dictionary, Indices                                                        |

---

### DBMS Architecture Levels

| **Level**            | **Description**                                                                                |
| -------------------------- | ---------------------------------------------------------------------------------------------------- |
| **Internal Level**   | Physical storage of data in hardware, manages compression and indexing.                              |
| **Conceptual Level** | Logical layout of the database, focusing on tables, attributes, and relationships.                   |
| **External Level**   | User interface level, tailored to provide specific views and interactions for different user groups. |

This summary and tabular representation condenses the key points of the content effectively for easy reference.

---

# **ER Diagram Overview**

- **Developed by**: Dr. Peter Chen in 1976.
- **Purpose**: Conceptual diagrammatic data representation for easy comprehension, especially for non-technical users.
- **Key Concept**: Entities and their relationships are modeled to create a **schema** representing real-world enterprise interactions.

---

### **Key Components of ER Diagrams**

#### **Entities**

- **Definition**: Real-world objects, both concrete (e.g., car, pen) and abstract (e.g., account, course).
- **Entity Set**: A collection of similar entities sharing the same properties or attributes.
- **Representation**: A rectangle in ER diagrams and as a table (row/record) in relational models.

#### **Types of Entities**

- **Tangible**: Physically exists (e.g., car, locker).
- **Intangible**: Exists logically (e.g., account, video).

#### **Attributes**

- **Definition**: Descriptive properties or characteristics of entities.
- **Representation**: Ellipses in ER diagrams, independent columns in relational models.

#### **Types of Attributes**

- **Single-Valued**: Holds a single value (e.g., Aadhaar number).
- **Multi-Valued**: Can have multiple values (e.g., phone numbers).
- **Simple**: Cannot be subdivided (e.g., age).
- **Composite**: Can be subdivided into simpler attributes (e.g., full name into first name, last name).
- **Stored**: Permanently stored (e.g., Date of Birth).
- **Derived**: Calculated from other attributes (e.g., Age from DOB).

---

### **Relationships**

- **Definition**: Association between two or more entities.
- **Representation**: Diamonds in ER diagrams; tables or foreign keys in relational models.

#### **Types of Relationships**

- **Unary**: Involves one entity set (self-referential).
- **Binary**: Involves two entity sets (most common).
- **Ternary/Quaternary/N-ary**: Involves three, four, or more entities.

---

### **Structural Constraints**

- **Cardinality Ratios**: Defines the number of entities that can be associated via a relationship:

  - **1:1** (One to One)
  - **1:M** (One to Many)
  - **M:1** (Many to One)
  - **M:N** (Many to Many)
- **Participation Constraints**: Indicates whether participation is partial or total.

---

### **Strong and Weak Entity Sets**

- **Strong Entity Set**: Has a primary key, making tuples distinguishable.
- **Weak Entity Set**: Lacks a primary key, dependent on a strong entity set.
  - **Represented by**: Double rectangle in ER diagrams.
  - **Identifying Relationship**: Many-to-One association between weak and strong entity sets, depicted as a double diamond.

---

### **Conversion from ER Diagram to Relational Model**

- **Entity Sets**: Convert strong/weak entity sets into tables.
- **Relationships**:
  - **Unary**: Add a new column as a foreign key.
  - **1:1**: Add primary key from one entity as foreign key in the other.
  - **1:N**: Add primary key of the "1" side as foreign key on the "N" side.
  - **M:N**: Create a new table with primary keys from both entities.
- **Attributes**:
  - **Multi-Valued**: Use a separate table.

---

Sure! Here are some additional points about ER Diagrams, including the types of ellipses used and other important aspects:

### 1. **Ellipses in ER Diagrams:**

- **Simple Ellipse (Single Line)**: Represents **single-valued attributes**, which have only one value for a particular entity (e.g., Age, Aadhar No.).
- **Double Ellipse**: Represents **multi-valued attributes**, which can have more than one value for an entity (e.g., Phone Numbers, Emails).
- **Dashed Ellipse**: Represents **derived attributes**, whose values can be derived from other attributes (e.g., Age derived from Date of Birth).
- **Ellipses inside an Ellipse (Composite Attribute)**: Represents **composite attributes**, which can be further broken down into sub-attributes (e.g., Address can be broken down into Street, City, Zip Code).

### 2. **Entity Representation:**

- **Rectangle**: Represents **entities** or **entity sets**. Entities are distinguishable objects in the real world. An entity set is a collection of entities sharing the same attributes.
- **Double Rectangle**: Represents a **weak entity set**. A weak entity is dependent on a strong entity and lacks a primary key. It requires a **discriminator** (partial key) and an identifying relationship with a strong entity.

### 3. **Relationship Representation:**

- **Diamond**: Represents **relationships** between entities. It shows how two or more entities are associated.
- **Double Diamond**: Represents an **identifying relationship** between a weak entity and a strong entity.
- **N-ary Relationship**: When more than two entities are involved in a relationship, an n-ary relationship is shown using a diamond with multiple connections.

### 4. **Types of Relationships and Participation:**

- **Cardinality Ratios**: Define the number of instances of an entity that can be associated with another entity in a relationship:
  - **1:1 (One-to-One)**: Each entity in A can be related to at most one entity in B, and vice versa.
  - **1:N (One-to-Many)**: Each entity in A can be related to many entities in B, but each entity in B can relate to only one entity in A.
  - **M:1 (Many-to-One)**: Many entities in A can be related to one entity in B.
  - **M:N (Many-to-Many)**: Entities in A can relate to many entities in B, and vice versa.
- **Participation Constraints**:
  - **Total Participation (Double Line)**: Every instance of an entity must participate in the relationship.
  - **Partial Participation (Single Line)**: Some instances of an entity may participate in the relationship.

### 5. **Attributes in ER Diagram:**

- **Key Attribute**: Attributes that uniquely identify an entity in an entity set, typically represented with an ellipse with the attribute name underlined.
- **Discriminator Attribute**: An attribute of a weak entity set that helps identify entities within that set, but not uniquely.
- **Multivalued Attribute**: Represented by a **double ellipse**, indicating that multiple values for that attribute can be associated with a single entity.

### 6. **Conversion of ER Diagram to Relational Model:**

- **Strong Entities**: Converted to tables where attributes become columns.
- **Weak Entities**: Converted into a table where they take the primary key from the strong entity they are related to.
- **Relationships**: Converted into tables (for many-to-many relationships) or incorporated into existing tables by adding foreign keys (for one-to-one, one-to-many relationships).

### 7. **Recursive Relationships**:

- These involve the same entity participating more than once in a relationship, often with different roles. These are sometimes referred to as **unary relationships** and are represented with a self-referencing arrow.

### 8. **Specialization and Generalization:**

- **Specialization**: An entity set is divided into smaller entity sets based on some distinguishing feature (e.g., Employee into Full-time and Part-time employees). Represented using an **is-a hierarchy**.
- **Generalization**: The opposite of specialization, where two or more entity sets are combined into a higher-level entity set.

### 9. **Aggregation**:

- This is used to represent a relationship between a relationship and other entities. It is depicted by enclosing a relationship set and associated entities inside a larger rectangle.

These are some additional key points that enhance the understanding of the ER diagram and how it represents entities, relationships, and attributes visually.

# MCQ mistakes I learnt from

https://www.interviewbit.com/dbms-mcq/

![1724001571536](image/DBMS/1724001571536.png)2. ![1724001609956](image/DBMS/1724001609956.png)

3. ![1724001725096](image/DBMS/1724001725096.png)
4. 

![1724001770974](image/DBMS/1724001770974.png)

![1724001825783](image/DBMS/1724001825783.png)

![1724002070960](image/DBMS/1724002070960.png)

![1724002166491](image/DBMS/1724002166491.png)

![1724002400266](image/DBMS/1724002400266.png)

![1724002445574](image/DBMS/1724002445574.png)


# **Normalization in RDBMS**

Normalization is a process in relational database design that organizes data to reduce redundancy and improve data integrity. The goal is to decompose a table into smaller, well-structured tables without losing any data.

Normalization typically involves dividing large tables into smaller ones and defining relationships between them. This process is guided by the application of **normal forms**, which are rules that govern the structure of the tables.

#### **Why Normalize?**

- **Minimizes Redundancy**: Reduces duplication of data, which saves storage space and reduces inconsistencies.
- **Improves Data Integrity**: Ensures that data dependencies are logically sound, minimizing anomalies during data operations (like insertion, deletion, and update).
- **Facilitates Maintenance**: Makes the database easier to maintain by enforcing clear relationships between tables.

#### **Normal Forms**

Each normal form has specific requirements that a table must satisfy. The most commonly used normal forms are:

1. **First Normal Form (1NF)**

   - **Definition**: A table is in 1NF if it contains only atomic (indivisible) values; each column contains unique values and each record has a unique identifier (primary key).
   - **Requirements**:
     - Eliminate repeating groups.
     - Each cell should contain a single value.
   - **Example**:
     - A table with customer data where multiple phone numbers are stored in a single cell would not be in 1NF. This would be corrected by creating a separate row for each phone number.
2. **Second Normal Form (2NF)**

   - **Definition**: A table is in 2NF if it is in 1NF and all non-key attributes are fully functionally dependent on the entire primary key.
   - **Requirements**:
     - Eliminate partial dependency: Ensure that non-key attributes depend on the whole primary key, not just part of it.
   - **Example**:
     - In a table where a composite key is used, if some attributes depend only on part of the composite key, those attributes should be moved to another table.
3. **Third Normal Form (3NF)**

   - **Definition**: A table is in 3NF if it is in 2NF and all attributes are functionally dependent only on the primary key.
   - **Requirements**:
     - Eliminate transitive dependency: Ensure that non-key attributes do not depend on other non-key attributes.
   - **Example**:
     - If a table contains a non-key attribute that is dependent on another non-key attribute, that relationship should be separated into its own table.
4. **Boyce-Codd Normal Form (BCNF)**

   - **Definition**: A table is in BCNF if it is in 3NF and every determinant is a candidate key.
   - **Requirements**:
     - The table must not have more than one candidate key; otherwise, each non-trivial functional dependency must have a superkey as its determinant.
   - **Example**:
     - If a table has two candidate keys, and one of them determines a non-key attribute, the table should be decomposed.
5. **Fourth Normal Form (4NF)**

   - **Definition**: A table is in 4NF if it is in BCNF and does not have any multi-valued dependencies.
   - **Requirements**:
     - A multi-valued dependency occurs when one attribute in a table uniquely determines another attribute, independent of all other attributes.
   - **Example**:
     - If a table contains two or more independent multi-valued attributes, it should be decomposed into separate tables for each attribute.
6. **Fifth Normal Form (5NF)**

   - **Definition**: A table is in 5NF if it is in 4NF and every join dependency in the table is implied by the candidate keys.
   - **Requirements**:
     - No table should be decomposable into smaller tables without loss of data.
   - **Example**:
     - In rare cases, a table may need to be decomposed further to ensure that the relationships among the data are properly maintained.

# **Functional Dependency in RDBMS**

Functional dependency is a relationship that exists when one attribute uniquely determines another attribute in a relational database.

#### **Key Concepts**

1. **Definition**:

   - A functional dependency is denoted as `X → Y`, where `X` and `Y` are attributes of a relation. The functional dependency means that if two tuples (rows) have the same value for `X`, they must have the same value for `Y`.
   - For example, if `A` and `B` are attributes of a relation, `A → B` means that for any two rows, if they have the same value for `A`, they must have the same value for `B`.
2. **Types of Functional Dependencies**:

   - **Trivial Functional Dependency**: A functional dependency is trivial if `Y` is a subset of `X`. For example, `X → X` or `{A, B} → A`.
   - **Non-Trivial Functional Dependency**: A functional dependency is non-trivial if `Y` is not a subset of `X`. For example, `A → B` where `B` is not a subset of `A`.
   - **Full Functional Dependency**: A functional dependency `X → Y` is full if it is non-trivial and the removal of any attribute from `X` means that the dependency no longer holds.
   - **Partial Functional Dependency**: Occurs when a non-key attribute is functionally dependent on part of a composite key.
   - **Transitive Dependency**: Occurs when one non-key attribute is dependent on another non-key attribute, which is dependent on the primary key.
3. **Armstrong's Axioms**:

   - A set of rules used to infer all functional dependencies on a relational database.
   - **Reflexivity**: If `Y` is a subset of `X`, then `X → Y`.
   - **Augmentation**: If `X → Y`, then `XZ → YZ` for any `Z`.
   - **Transitivity**: If `X → Y` and `Y → Z`, then `X → Z`.

#### **Importance of Functional Dependencies**:

- **Normalization**: Functional dependencies are the backbone of normalization, as they help in identifying the correct structure of a relational schema.
- **Data Integrity**: Ensuring that functional dependencies are respected in a database prevents anomalies and ensures data consistency.
- **Schema Design**: Understanding and applying functional dependencies is crucial for effective schema design, leading to a well-structured, efficient, and reliable database.

### **Summary**

- **Normalization** is crucial for minimizing redundancy and improving data integrity in a database. It involves applying a series of normal forms, from 1NF to 5NF.
- **Functional Dependency** is a relationship where one attribute uniquely determines another, playing a key role in database design and normalization.


### **Normalization in RDBMS**

Normalization is a database design technique used to minimize redundancy and dependency by organizing fields and table relationships in a database. The goal of normalization is to divide larger tables into smaller, manageable tables without losing data integrity and to ensure data dependencies make sense.

#### **Why Normalize?**

- **Eliminate Redundant Data:** To ensure that each piece of data is stored only once, reducing data redundancy.
- **Ensure Data Integrity:** To prevent anomalies like update, insertion, and deletion anomalies.
- **Simplify Queries:** Well-structured tables make querying easier and more efficient.

#### **Normalization Process:**

Normalization is achieved through a series of steps called **Normal Forms (NFs)**, each with specific requirements. Below are the most common normal forms:

---

#### **1. First Normal Form (1NF):**

A table is in 1NF if:

- All column values are atomic (indivisible).
- Each column contains only one value.
- Each record is unique, i.e., there is a unique key.

**Example:**

- A table with a column for phone numbers that allows multiple numbers (e.g., `123, 456`) violates 1NF because the column is not atomic. Splitting these into separate rows would bring it to 1NF.

**Anomalies Resolved:** Repeating groups are removed, and the table becomes a true relation.

---

#### **2. Second Normal Form (2NF):**

A table is in 2NF if:

- It is already in 1NF.
- All non-key attributes are fully functionally dependent on the primary key.

**Example:**

- Consider a table where a composite key is used, and a non-key attribute depends only on part of the composite key. Such partial dependencies should be removed by splitting the table.

**Anomalies Resolved:** Partial dependencies are removed, thus reducing redundancy.

---

#### **3. Third Normal Form (3NF):**

A table is in 3NF if:

- It is already in 2NF.
- There is no transitive dependency, i.e., non-key attributes do not depend on other non-key attributes.

**Example:**

- If `A → B` and `B → C`, then `A → C` is a transitive dependency. To achieve 3NF, `C` should be moved to a separate table where `B` is the primary key.

**Anomalies Resolved:** Transitive dependencies are removed, making the data structure more robust.

---

#### **4. Boyce-Codd Normal Form (BCNF):**

A table is in BCNF if:

- It is in 3NF.
- For every functional dependency `X → Y`, `X` is a superkey.

**Example:**

- In some cases, even if a table is in 3NF, it may have dependencies where a candidate key is not a superkey. BCNF addresses this issue.

**Anomalies Resolved:** More strict than 3NF, BCNF ensures no anomalies remain related to candidate keys.

---

#### **5. Fourth Normal Form (4NF):**

A table is in 4NF if:

- It is in BCNF.
- It has no multi-valued dependencies.

**Example:**

- If a table has columns like `Student`, `Course`, and `Hobby`, where a student can have multiple courses and hobbies, the table should be decomposed to eliminate multi-valued dependencies.

**Anomalies Resolved:** Removes multi-valued dependencies.

---

#### **6. Fifth Normal Form (5NF):**

A table is in 5NF if:

- It is in 4NF.
- It cannot be decomposed into smaller tables without losing data.

**Example:**

- A complex table with multiple candidate keys and relations may need to be split into smaller tables, ensuring no loss of information or dependencies.

**Anomalies Resolved:** Ensures that no join dependencies remain.

---

### **Functional Dependency (FD) in RDBMS**

Functional Dependency is a fundamental concept that underpins the theory of database normalization. It describes the relationship between attributes in a table.

#### **Definition:**

A functional dependency, denoted by `X → Y`, between two sets of attributes `X` and `Y` in a relation (table) means that if two tuples (rows) have the same values for `X`, they must have the same values for `Y`. In other words, `Y` is functionally dependent on `X`.

#### **Key Points about Functional Dependency:**

1. **Trivial Functional Dependency:**

   - A dependency is trivial if `Y` is a subset of `X`.
   - Example: `{StudentID, Name} → {StudentID}` is trivial.
2. **Non-Trivial Functional Dependency:**

   - A dependency is non-trivial if `Y` is not a subset of `X`.
   - Example: `StudentID → Name` is non-trivial if `Name` is not part of `StudentID`.
3. **Full Functional Dependency:**

   - A functional dependency is full if removal of any attribute from `X` means the dependency no longer holds.
   - Example: `{StudentID, CourseID} → Grade` is full if `Grade` is dependent on both `StudentID` and `CourseID`.
4. **Partial Functional Dependency:**

   - Occurs when a non-key attribute is functionally dependent on part of a composite key.
   - Example: `{StudentID, CourseID} → CourseName` is partial if `CourseName` is dependent only on `CourseID`.
5. **Transitive Dependency:**

   - Occurs when a non-key attribute depends on another non-key attribute.
   - Example: `StudentID → AdvisorID` and `AdvisorID → AdvisorName` imply `StudentID → AdvisorName`, which is a transitive dependency.

#### **Role in Normalization:**

- Functional dependencies are used to identify how attributes relate to each other and to determine which normal form a table satisfies.
- By analyzing FDs, one can decide how to decompose tables to achieve a higher normal form.

---

### **Normalization vs. Denormalization:**

- **Normalization** ensures data integrity and reduces redundancy, but it might lead to complex queries and potentially slower performance.
- **Denormalization** involves combining tables to reduce joins and increase performance, but it can introduce redundancy and anomalies.

### **Interview Tips:**

- **Be prepared to explain:** The reasons for each step in normalization, especially how FDs affect the process.
- **Be ready to demonstrate:** How you would normalize a given set of tables to a particular normal form.
- **Understand trade-offs:** Between normalization and denormalization in real-world database design.

These notes should give you a solid understanding of normalization and functional dependencies in RDBMS, which are key topics often covered in technical interviews.
