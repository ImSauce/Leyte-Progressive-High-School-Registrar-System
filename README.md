<h1> Leyte Progressive High School Registrar System </h1>

<p>
  A desktop-based <strong>Registrar System</strong> developed for <strong>Leyte Progressive High School</strong> to efficiently manage and store student records.
  This application streamlines enrollment processes, organizes student data, and supports registrar staff with digital tools.
</p>

<hr>

<h2> 📖 Table of Contents </h2>
<ul>
  <li><a href="#features">Features</a></li>
  <li><a href="#technologies-used">Technologies Used</a></li>
  <li><a href="#project-structure">Project Structure</a></li>
  <li><a href="#getting-started">Getting Started</a></li>
  <li><a href="#future-enhancements">Future Enhancements</a></li>
  <li><a href="#about-the-school">About the School</a></li>
  <li><a href="#contributing">Contributing</a></li>
  <li><a href="#license">License</a></li>
</ul>

<hr>

<h2 id="features">Features</h2>
<ul>
  <li>Student registration and profile management</li>
  <li>Enrollment tracking by academic year</li>
  <li>Grade level and section assignment</li>
  <li>User authentication (optional)</li>
  <li>Modular code structure for future upgrades</li>
</ul>

<hr>

<h2 id="technologies-used">Technologies Used</h2>
<table>
  <tr>
    <th>Component</th>
    <th>Technology</th>
  </tr>
  <tr>
    <td>Programming Language</td>
    <td>Java</td>
  </tr>
  <tr>
    <td>User Interface</td>
    <td>Java Swing / JavaFX</td>
  </tr>
  <tr>
    <td>Database</td>
    <td>MySQL or SQLite</td>
  </tr>
  <tr>
    <td>Database Connector</td>
    <td>JDBC</td>
  </tr>
  <tr>
    <td>Executable Packaging</td>
    <td>Launch4j</td>
  </tr>
  <tr>
    <td>Installer Builder</td>
    <td>Inno Setup</td>
  </tr>
</table>

<hr>

<h2 id="project-structure">Project Structure</h2>

<pre>
RegistrarSystem/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   ├── Main.java
│   │   │   ├── database/
│   │   │   ├── models/
│   │   │   └── ui/
│   └── resources/
├── database/
│   └── registrar_db.sql
├── README.md
└── LICENSE
</pre>

<hr>

<h2 id="getting-started">Getting Started</h2>

<h3>Prerequisites</h3>
<ul>
  <li>Java Development Kit (JDK 8 or later)</li>
  <li>MySQL or SQLite</li>
  <li>Any Java IDE (e.g., IntelliJ IDEA, Eclipse)</li>
</ul>

<h3>Setup Instructions</h3>

<details>
  <summary><strong>1. Clone the Repository</strong></summary>
  <pre><code>git clone https://github.com/yourusername/registrar-system.git
cd registrar-system</code></pre>
</details>

<details>
  <summary><strong>2. Set Up the Database</strong></summary>
  <ul>
    <li>Import the <code>registrar_db.sql</code> file located in the <code>/database</code> folder into your MySQL or SQLite server.</li>
    <li>Update your database connection settings inside the Java code.</li>
  </ul>
</details>

<details>
  <summary><strong>3. Run the Application</strong></summary>
  <ul>
    <li>Open the project in your IDE.</li>
    <li>Run <code>Main.java</code>.</li>
  </ul>
</details>

<details>
  <summary><strong>4. Package as Executable (Optional)</strong></summary>
  <ul>
    <li>Use Launch4j to convert the JAR file to an EXE.</li>
    <li>Use Inno Setup to create an installer for distribution.</li>
  </ul>
</details>

<hr>

<h2 id="future-enhancements">Future Enhancements</h2>
<ul>
  <li>Printable forms and reports</li>
  <li>Grade management and transcripts</li>
  <li>Administrator dashboard</li>
  <li>Search and filtering features</li>
</ul>

<hr>

<h2 id="about-the-school">About the School</h2>
<p>
  <strong>Leyte Progressive High School</strong> is a private educational institution in the Philippines committed to integrating digital technologies to enhance administrative processes and student services.
</p>

<hr>

<h2 id="contributing">Contributing</h2>
<p>
  Contributions are welcome. To contribute:
</p>
<ol>
  <li>Fork this repository</li>
  <li>Create a new branch (<code>git checkout -b feature-name</code>)</li>
  <li>Commit your changes</li>
  <li>Push to your fork and open a pull request</li>
</ol>

<hr>

<h2 id="license">License</h2>
<p>
  This project is licensed under the <strong>MIT License</strong>. See the <code>LICENSE</code> file for more information.
</p>
