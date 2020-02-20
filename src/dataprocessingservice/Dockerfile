FROM python:3.7
RUN pip install pandas flask gunicorn
COPY . .
EXPOSE 5000
CMD ["gunicorn", "-b", "0.0.0.0:5000", "app"]
