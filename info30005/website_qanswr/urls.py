from django.conf.urls import patterns, url

from website_qanswr import views

urlpatterns = patterns('',
	url(r'^$', views.index, name='home'),
)