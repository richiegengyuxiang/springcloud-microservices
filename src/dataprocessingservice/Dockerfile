FROM python:3.7
WORKDIR /usr/src/dataprocessingservice
RUN pip install pandas flask gunicorn
COPY . .
EXPOSE 5000
EXPOSE 80 2222
CMD ["gunicorn", "-b", "0.0.0.0:5000", "app"]
