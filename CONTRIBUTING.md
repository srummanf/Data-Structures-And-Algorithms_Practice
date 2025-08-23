# Contributing Guidelines

Thank you for your interest in contributing to our Data Structures and Algorithms, SQL, Data Analysis & Data Science Interview Practice repository! 🚀

## 📋 Table of Contents

* [Getting Started](#getting-started)
* [Types of Contributions](#types-of-contributions)
* [Adding Companies and Problems](#adding-companies-and-problems)
* [Bug Fixes and Page Improvements](#bug-fixes-and-page-improvements)
* [Submission Guidelines](#submission-guidelines)
* [Code Style Guidelines](#code-style-guidelines)

## 🚀 Getting Started

### Fork and Clone the Repository

```bash
# Fork the repository on GitHub first, then clone your fork
git clone https://github.com/YOUR_USERNAME/Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice.git

# Navigate to the project directory
cd Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice

# Add the original repository as upstream
git remote add upstream https://github.com/srummanf/Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice.git

# Verify remotes
git remote -v
```

## 📝 Types of Contributions

| Contribution Type           | Description                          | File Location             |
| --------------------------- | ------------------------------------ | ------------------------- |
| **Adding Companies**  | Add new company with problems        | `data/companyTags.json` |
| **Adding Problems**   | Add problems to existing companies   | `data/companyTags.json` |
| **Bug Fixes**         | Fix issues in existing code/content  | Various files             |
| **Documentation**     | Improve README, guides, explanations | Markdown files            |
| **Page Improvements** | Enhance UI/UX, formatting            | HTML/CSS files            |

## 🏢 Adding Companies and Problems

### Step 1: Check if Company Exists

Before adding a new problem, search for the company in [`data/companyTags.json`](https://github.com/srummanf/Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice/blob/main/data/companyTags.json)

```bash
# Search for company in the JSON file
grep -i "company_name" data/companyTags.json
```

### Step 2a: Adding Problem to Existing Company

If the company exists, add your problem in this exact format:

```json
{
  "problem_name": "Time Based Key-Value Store",
  "leetcode_number": "1023",
  "leetcode_link": "https://leetcode.com/problems/time-based-key-value-store",
  "solution_yt_link": "https://algo.monster/liteproblems/1023",
  "intuition": "",
  "key_steps": ""
}
```

### Step 2b: Adding New Company with Problem

If the company doesn't exist, add a new company entry:

```json
{
  "company_name": [
    {
      "problem_name": "Problem Name",
      "leetcode_number": "XXXX",
      "leetcode_link": "https://leetcode.com/problems/problem-name",
      "solution_yt_link": "YouTube or solution link",
      "intuition": "Brief explanation of the approach",
      "key_steps": "Key steps to solve the problem"
    }
  ]
}
```

### Required Fields Checklist

When adding a problem, ensure all fields are included:

* [ ] `problem_name` - Exact name from LeetCode
* [ ] `leetcode_number` - Problem number from LeetCode
* [ ] `leetcode_link` - Direct link to LeetCode problem
* [ ] `solution_yt_link` - YouTube video or solution explanation link
* [ ] `intuition` - Brief explanation (can be empty initially)
* [ ] `key_steps` - Key solution steps (can be empty initially)

### Screenshot Requirement

 **📸 IMPORTANT** : Attach a screenshot showing the problem exists on the company's interview platform or reliable source for authenticity verification.

**Acceptable Screenshot Sources:**

* LeetCode company tag
* GeeksforGeeks company problems
* InterviewBit company section
* Glassdoor interview experiences
* Official company coding challenge pages

## 🐛 Bug Fixes and Page Improvements

### Common Areas for Improvement

| Area                          | Description                     | Files Involved            |
| ----------------------------- | ------------------------------- | ------------------------- |
| **JSON Formatting**     | Fix malformed JSON syntax       | `data/companyTags.json` |
| **Broken Links**        | Update dead or incorrect links  | Various JSON/MD files     |
| **Typos**               | Fix spelling and grammar errors | All text files            |
| **Duplicate Entries**   | Remove duplicate problems       | `data/companyTags.json` |
| **Missing Information** | Add missing intuition/key_steps | `data/companyTags.json` |

### Bug Fix Process

1. **Identify the Issue**
   * [ ] Create an issue describing the bug
   * [ ] Include steps to reproduce
   * [ ] Add screenshots if applicable
2. **Fix the Bug**
   * [ ] Create a new branch for the fix
   * [ ] Make necessary changes
   * [ ] Test your changes locally
   * [ ] Commit with descriptive message

## 📋 Submission Guidelines

### Branch Naming Convention

```bash
# For adding companies/problems
git checkout -b add-company-[company-name]
git checkout -b add-problem-[problem-name]

# For bug fixes
git checkout -b fix-[issue-description]

# For improvements
git checkout -b improve-[feature-name]
```

### Commit Message Format

```bash
# Adding new company
git commit -m "Add [Company Name] with [X] problems"

# Adding problem to existing company
git commit -m "Add [Problem Name] to [Company Name]"

# Bug fixes
git commit -m "Fix [brief description of bug]"

# Improvements
git commit -m "Improve [what was improved]"
```

### Pull Request Process

1. **Update Your Fork**

```bash
# Fetch latest changes from upstream
git fetch upstream
git checkout main
git merge upstream/main
git push origin main
```

2. **Create Feature Branch**

```bash
git checkout -b your-feature-branch
# Make your changes
git add .
git commit -m "Your descriptive commit message"
git push origin your-feature-branch
```

3. **Create Pull Request**
   * [ ] Go to your fork on GitHub
   * [ ] Click "New Pull Request"
   * [ ] Fill out the PR template
   * [ ] Include screenshots for authenticity
   * [ ] Link any related issues

### Pull Request Checklist

Before submitting your PR, ensure:

* [ ] JSON syntax is valid (use JSON validator)
* [ ] All required fields are present
* [ ] Links are working and accessible
* [ ] No duplicate entries
* [ ] Screenshot attached for new companies/problems
* [ ] Commit messages are descriptive
* [ ] PR description explains the changes clearly

## 📏 Code Style Guidelines

### JSON Formatting Rules

```json
{
  "company_name": "Consistent Title Case",
  "problems": [
    {
      "problem_name": "Exact LeetCode Title",
      "leetcode_number": "Numbers only, no #",
      "leetcode_link": "https://leetcode.com/problems/exact-url",
      "solution_yt_link": "Valid URL",
      "intuition": "Brief, clear explanation",
      "key_steps": "Numbered or bulleted steps"
    }
  ]
}
```

### Validation Commands

```bash
# Validate JSON syntax
python -m json.tool data/companyTags.json > /dev/null && echo "Valid JSON" || echo "Invalid JSON"

# Check for duplicate problem numbers
grep -o '"leetcode_number": "[^"]*"' data/companyTags.json | sort | uniq -d
```


## 🆘 Getting Help

### Communication Channels

| Platform                     | Purpose                       | Link                                                                                                            |
| ---------------------------- | ----------------------------- | --------------------------------------------------------------------------------------------------------------- |
| **GitHub Issues**      | Bug reports, feature requests | [Create Issue](https://github.com/srummanf/Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice/issues)     |
| **GitHub Discussions** | Questions, general discussion | [Discussions](https://github.com/srummanf/Data-Structures-And-Algorithms_SQL-DA-DS_Interview-Practice/discussions) |

### Common Git Commands Reference

```bash
# Check status
git status

# View changes
git diff

# Stage specific files
git add filename.json

# Stage all changes
git add .

# Commit changes
git commit -m "Descriptive message"

# Push to your fork
git push origin branch-name

# Update from upstream
git fetch upstream
git rebase upstream/main

# Squash commits (interactive rebase)
git rebase -i HEAD~3
```

## 📄 License

By contributing to this repository, you agree that your contributions will be licensed under the same license as the project.


