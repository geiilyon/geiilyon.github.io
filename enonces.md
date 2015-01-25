---
layout: page
title: Enoncés
modified:
excerpt: Sujets des travaux pratiques
image:
  feature: ocean.png
  teaser:
  thumb:
permalink: /enonces/
---

# Test de page

<div class="home">

  <ul class="post-list">
{% for tp in site.collection_enonces %}
      <li>
        <h2>
          <a class="post-link" href="{{ tp.url | prepend: site.baseurl }}">{{ tp.title }}</a>
        </h2>
      </li>
    {% endfor %}
</ul>


</div>