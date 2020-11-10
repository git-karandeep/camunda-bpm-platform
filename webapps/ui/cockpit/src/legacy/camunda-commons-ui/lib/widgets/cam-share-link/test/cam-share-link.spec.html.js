/*
 * Copyright Camunda Services GmbH and/or licensed to Camunda Services GmbH
 * under one or more contributor license agreements. See the NOTICE file
 * distributed with this work for additional information regarding copyright
 * ownership. Camunda licenses this file to you under the Apache License,
 * Version 2.0; you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

module.exports = `<html>
  <head>
    <title>Camunda commons UI library</title>
    <base href="/" />
    <!--[if IE]><script type="text/javascript">
        // Fix for IE ignoring relative base tags.
        // See http://stackoverflow.com/questions/3926197/html-base-tag-and-local-folder-path-with-internet-explorer
        (function() {
            var baseTag = document.getElementsByTagName('base');
            if (baseTag[0]) { baseTag[0].href = baseTag[0].href; }
        })();
    </script><![endif]-->
    <link rel="icon" href="resources/img/favicon.ico" />
    <link href="styles.css" rel="stylesheet" />
    <link href="test-styles.css" rel="stylesheet" />
  </head>
  <body class="cam-widget-clipboard-test-page">
    <!-- gh-pages-menu -->

    <header>
      <div>
        <h1>Share Link</h1>
      </div>
    </header>

        <section class="widget-description">
      <header>
        <h2>Description</h2>
      </header>
      <p>Adds a button allowing to easily copy current url to clipboard.</p>
    </section>

    <section class="widget-examples">
      <header>
        <h2>Examples</h2>
      </header>

      <div class="widget-example"
           id="default">
        <h3>Basic usage</h3>
        <pre ng-non-bindable>&lt;span cam-share-link&gt;&lt;/span&gt;</pre>
        <div class="test-container">
          <span cam-share-link></span>
          <input id="target">
        </div><!-- /.test-container -->
      </div><!-- /.widget-example -->
    </section>

    <!-- gh-pages-footer -->

    <script src="lib/widgets/cam-share-link/test/cam-share-link.build.js"></script>
  </body>
</html>
`;
