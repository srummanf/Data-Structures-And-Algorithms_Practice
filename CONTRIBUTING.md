# Contributing Guidelines

Thank you for your interest in contributing to **DSA Atlas**. This project brings together resources for Data Structures and Algorithms, Aptitude, SQL, Data Analytics, Machine Learning, and Interview Preparation. Contributions from the community play a vital role in keeping the repository accurate, useful, and up to date.

This document outlines how you can contribute, the types of contributions we welcome, and the standards we ask contributors to follow.

---

## Table of Contents

- [Contributing Guidelines](#contributing-guidelines)
  - [Table of Contents](#table-of-contents)
  - [Ways You Can Contribute](#ways-you-can-contribute)
  - [Contribution Workflow](#contribution-workflow)
  - [Standards and Best Practices](#standards-and-best-practices)
  - [JSON Style Guidelines](#json-style-guidelines)
    - [General Rules](#general-rules)
    - [Example: Adding a Problem to an Existing Company](#example-adding-a-problem-to-an-existing-company)
    - [Example: Adding a New Company](#example-adding-a-new-company)
    - [Required Fields Checklist](#required-fields-checklist)
  - [Contribution Workflow](#contribution-workflow-1)
  - [Pull Request Checklist](#pull-request-checklist)
  - [Getting Help](#getting-help)
  - [License](#license)

---

## Ways You Can Contribute

We welcome contributions in several forms, including but not limited to:

* **Adding New Study Materials and Resources**
  Upload structured notes, curated PDFs, or links to reputable study content.

* **Improving Existing Content and Documentation**
  Refine explanations, fix formatting issues, enhance examples, or expand coverage where details are missing.

* **Submitting Bug Fixes and Enhancements**
  Address broken links, correct malformed data, remove duplicates, and suggest improvements to scripts or the website.

* **Following Code and Content Standards**
  Ensure new material follows consistent naming, formatting, and structural guidelines to maintain clarity across the repository.

---

## Contribution Workflow

1. **Fork the Repository**
   Begin by forking the repository to your own GitHub account.

2. **Clone Your Fork**

   ```bash
   git clone https://github.com/<your-username>/dsahub.git
   cd dsahub
   ```

3. **Create a Branch**
   Use descriptive branch names to clearly indicate the purpose of your changes.

   ```bash
   git checkout -b add-resource-dynamic-programming
   git checkout -b fix-broken-link-sql-notes
   ```

4. **Make Your Changes**

   * Add new content or update existing files.
   * Test locally where applicable (scripts, JSON validation, etc.).

5. **Commit Your Work**
   Write meaningful commit messages:

   ```bash
   git commit -m "Add new dynamic programming problems to DSA section"
   git commit -m "Fix broken YouTube link in company-wise questions"
   ```

6. **Push to Your Fork and Submit a Pull Request**

   ```bash
   git push origin your-branch-name
   ```

   Then open a Pull Request (PR) against the main repository’s `main` branch.

---

## Standards and Best Practices

* **File Organization**
  Place new files in the correct directory (`Aptitude/`, `SQL/`, `Data Structures and Algorithms/`, etc.).

* **Content Consistency**

  * Use consistent formatting for markdown, JSON, and code.
  * For problem sets, include all required fields (e.g., problem name, link, intuition, key steps).

* **Code Style**

  * Keep JSON properly formatted and validated.
  * Use descriptive variable and file names.
  * Ensure scripts are well-commented.

* **Documentation Quality**
  All additions should be clear, concise, and helpful to learners. Avoid redundancy where possible.

---
## JSON Style Guidelines

Since many sections of this repository (such as **company-wise problem sets**) are stored in JSON, contributors must follow these rules for consistency and validation:

### General Rules

* Use **valid JSON syntax** (commas, quotes, and braces properly placed).
* Maintain **consistent indentation** of two spaces.
* Use **double quotes** for all keys and values.
* Do not leave trailing commas at the end of objects or arrays.

### Example: Adding a Problem to an Existing Company

```json
{
  "problem_name": "Time Based Key-Value Store",
  "leetcode_number": "981",
  "leetcode_link": "https://leetcode.com/problems/time-based-key-value-store",
  "solution_yt_link": "https://www.youtube.com/example",
  "intuition": "Use a hashmap with timestamps to store values efficiently.",
  "key_steps": "1. Maintain a map of key -> [(timestamp, value)]\n2. Use binary search to retrieve value <= timestamp."
}
```

### Example: Adding a New Company

```json
{
  "New Company": [
    {
      "problem_name": "Example Problem",
      "leetcode_number": "123",
      "leetcode_link": "https://leetcode.com/problems/example-problem",
      "solution_yt_link": "https://www.youtube.com/example",
      "intuition": "Brief explanation of the approach.",
      "key_steps": "Key steps listed here."
    }
  ]
}
```

### Required Fields Checklist

* `problem_name` – Exact name from LeetCode.
* `leetcode_number` – The problem number (numbers only, no `#`).
* `leetcode_link` – Direct link to the problem.
* `solution_yt_link` – Link to a video explanation or article.
* `intuition` – Short description of the main idea (can be empty initially).
* `key_steps` – Steps to solve the problem (can be empty initially).

Always validate your JSON before submitting:

```bash
python -m json.tool data/companyTags.json > /dev/null && echo "Valid JSON" || echo "Invalid JSON"
```

---

## Contribution Workflow

1. **Fork and Clone**

   ```bash
   git clone https://github.com/<your-username>/dsahub.git
   cd dsahub
   ```

2. **Create a Branch**

   ```bash
   git checkout -b add-problem-two-sum
   ```

3. **Make Changes**

   * Add or update JSON entries.
   * Validate your JSON.

4. **Commit and Push**

   ```bash
   git commit -m "Add Two Sum problem to Amazon company list"
   git push origin add-problem-two-sum
   ```

5. **Submit a Pull Request**
   Open a PR against the main branch and explain your changes.

---


## Pull Request Checklist

Before submitting a PR, please ensure:

* [ ] JSON and scripts validate without errors.
* [ ] Links are active and point to reliable sources.
* [ ] No duplicate problems or resources have been added.
* [ ] Commit messages are descriptive.
* [ ] The PR description explains the purpose and scope of changes.

---

## Getting Help

If you encounter issues or have questions about contributing:

* Open an [Issue](../../issues) for bug reports or feature requests.
* Use [Discussions](../../discussions) for general queries or collaboration.

---

## License

By contributing, you agree that your submissions will be licensed under the same license as this repository. Please review the [LICENSE.md](./LICENSE.md) file for details.



