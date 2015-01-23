---
layout: post
title:  "Welcome to Jekyll!"
date:   2015-01-21 13:50:07
categories: jekyll update
---
You’ll find this post in your `_posts` directory. Go ahead and edit it and re-build the site to see your changes. You can rebuild the site in many different ways, but the most common way is to run `jekyll serve`, which launches a web server and auto-regenerates your site when a file is updated.

To add new posts, simply add a file in the `_posts` directory that follows the convention `YYYY-MM-DD-name-of-post.ext` and includes the necessary front matter. Take a look at the source for this post to get an idea about how it works.

Jekyll also offers powerful support for code snippets:

{% highlight ruby %}
def print_hi(name)
  puts "Hi, #{name}"
end
print_hi('Tom')
#=> prints 'Hi, Tom' to STDOUT.
{% endhighlight %}

Check out the [Jekyll docs][jekyll] for more info on how to get the most out of Jekyll. File all bugs/feature requests at [Jekyll’s GitHub repo][jekyll-gh]. If you have questions, you can ask them on [Jekyll’s dedicated Help repository][jekyll-help].

[jekyll]:      http://jekyllrb.com
[jekyll-gh]:   https://github.com/jekyll/jekyll
[jekyll-help]: https://github.com/jekyll/jekyll-help

## Data Types

### Size

Permissible sizes of data types are determined by how many bytes of memory are allocated for that specific type and whether it's a 32-bit or 64-bit environment.  In a 32-bit environment, `long` is given 4 bytes, which equates to a total range of `2^(4*8)` (with 8 bits in a byte) or `4294967295`.  In a 64-bit environment, `long` is given 8 bytes, which equates to `2^(8*8)` or `1.84467440737096e19`.

For a complete guide to 64-bit changes, please [see the transition document](https://developer.apple.com/library/mac/documentation/Darwin/Conceptual/64bitPorting/transition/transition.html#//apple_ref/doc/uid/TP40001064-CH207-TPXREF101).

### C Primitives

Unless you have a good reason to use C primitives, you should just use the Swift types to ensure compability going foward.

In fact, Swift just aliases C types to a Swift equivalent:

```ruby
module Jekyll
  class TagIndex < Page
    def initialize(site, base, dir, tag)
      @site = site
      @base = base
      @dir = dir
      @name = 'index.html'
      self.process(@name)
      self.read_yaml(File.join(base, '_layouts'), 'tag_index.html')
      self.data['tag'] = tag
      tag_title_prefix = site.config['tag_title_prefix'] || 'Tagged: '
      tag_title_suffix = site.config['tag_title_suffix'] || '&#8211;'
      self.data['title'] = "#{tag_title_prefix}#{tag}"
      self.data['description'] = "An archive of posts tagged #{tag}."
    end
  end
end
```

From the [docs](https://developer.apple.com/library/ios/documentation/swift/conceptual/buildingcocoaapps/InteractingWithCAPIs.html):

C Type | Swift Type
:---: | :---:
bool | CBool
char, signed char | CChar
unsigned char | CUnsignedChar
short | CShort
unsigned short | CUnsignedShort
int | CInt
unsigned int | CUnsignedInt
long | CLong
unsigned long | CUnsignedLong
long long | CLongLong
unsigned long long | CUnsignedLongLong
wchar_t | CWideChar
char16_t | CChar16
char32_t | CChar32
float | CFloat
double | CDouble

```swift
if item is Movie {
    ++movieCount
    println("It is a movie.")
} else if item is Song {
    ++songCount
    println("It is a song.")
}

```
