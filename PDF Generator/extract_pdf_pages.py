from PyPDF2 import PdfReader, PdfWriter

# Load the existing PDF
input_pdf_path = 'C:/Users/Rumman Fardeen/Desktop/DSA_Coding/PDF Generator/source/OS.pdf'
output_pdf_path = 'C:/Users/Rumman Fardeen/Desktop/DSA_Coding/PDF Generator/destination/OS_RaceConditionAndSemaphores.pdf'

reader = PdfReader(input_pdf_path)
writer = PdfWriter()

# Pages are zero-indexed, so x is page x and y is page y+1
for page_num in range(98, 141):
    page = reader.pages[page_num]
    writer.add_page(page)

# Save the new PDF
with open(output_pdf_path, 'wb') as output_pdf:
    writer.write(output_pdf)

print("PDF extraction complete!")
