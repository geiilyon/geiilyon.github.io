---
layout: page
title: Enoncés
modified:
excerpt: Sujets des travaux pratiques.
permalink: /enonces/
---

<div class="home">

{% for tp in site.collection_enonces %}
<div class="panel panel-info">
  <div class="panel-heading">
    <h3 class="panel-title">{{ tp.title }}</h3>
  </div>
  <div class="panel-body">
    <a class="post-link" href="{{ tp.url | prepend: site.baseurl }}">{{ tp.excerpt }}</a>
  </div>
</div>
    {% endfor %}


</div>