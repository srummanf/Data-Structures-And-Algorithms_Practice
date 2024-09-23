
# PDF Page Extractor

This Python script allows you to extract specific pages from an existing PDF and save them as a new PDF file. It is useful when you need to create a smaller PDF from selected pages of a larger document.

## Prerequisites

To use this script, you need to have the following installed:

- **Python 3.x**: If you don’t have Python installed, you can download it from [python.org](https://www.python.org/downloads/).
- **PyPDF2 library**: This library is used for reading, writing, and manipulating PDF files.

### Installing PyPDF2

You can install `PyPDF2` using `pip`. Run the following command in your terminal or command prompt:

```bash
pip install PyPDF2
```

## Usage

### Step 1: Prepare the Script

Copy the code below into a Python file, e.g., `extract_pdf_pages.py`.

```python
from PyPDF2 import PdfReader, PdfWriter

# Specify the path to your PDF file
input_pdf_path = 'path/to/your/400-page.pdf'

# Specify the output path for the new PDF file
output_pdf_path = 'path/to/output.pdf'

# Load the existing PDF
reader = PdfReader(input_pdf_path)
writer = PdfWriter()

# Pages are zero-indexed, so 33 is page 34 and 155 is page 156
# Adjust the range to extract desired pages (e.g., pages 34 to 156)
for page_num in range(33, 156):
    page = reader.pages[page_num]
    writer.add_page(page)

# Save the new PDF to the output path
with open(output_pdf_path, 'wb') as output_pdf:
    writer.write(output_pdf)

print("PDF extraction complete!")
```

### Step 2: Customize the Script

- **Input PDF Path**: Change `'path/to/your/400-page.pdf'` to the file path of your input PDF.
- **Output PDF Path**: Specify where you want to save the new PDF by changing `'path/to/output.pdf'`.
- **Page Range**: Adjust the range in the `for` loop to match the pages you want to extract. Remember, the pages in `PyPDF2` are zero-indexed, meaning the first page is page `0`.

### Step 3: Run the Script

Once you've customized the script, you can run it from the terminal or command prompt:

```bash
python extract_pdf_pages.py
```

After running the script, a new PDF will be created at the specified output path, containing only the extracted pages.

## Example

If you want to extract pages 34 to 156 from a 400-page PDF:

1. Set `input_pdf_path = 'path/to/your/400-page.pdf'`.
2. Set `output_pdf_path = 'path/to/output.pdf'`.
3. Modify the page range to `for page_num in range(33, 156)`.

Running the script will create a new PDF with pages 34 through 156.

### Output

The script will print:

```
PDF extraction complete!
```

## Troubleshooting

- **File Not Found Error**: Ensure the file path you provide in `input_pdf_path` is correct.
- **Incorrect Page Range**: Remember that pages in `PyPDF2` are zero-indexed. If you want to extract, for example, pages 1-10, you need to set the range as `range(0, 10)`.
