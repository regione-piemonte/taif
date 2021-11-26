#-------------------------------------------------------------------------------
# Copyright CSI-Piemonte -2021
# SPDX-License-Identifier: EUPL-1.2-or-later.
#-------------------------------------------------------------------------------
// for old browsers
window.undefined = window.undefined;

/**
 * @class OOJS
 * OOJS core utilities and functions.
 * @singleton
 */

OOJS = {
    /**
     * The version of the framework
     * @type String
     */
    version : '1.0.0',
    versionDetail : {
        major : 1,
        minor : 0,
        patch : 0
    }
};

/**
 * Copies all the properties of config to obj.
 * @param {Object} obj The receiver of the properties
 * @param {Object} config The source of the properties
 * @param {Object} defaults A different object that will also be applied for default values
 * @return {Object} returns obj
 * @member OOJS apply
 */
OOJS.apply = function(o, c, defaults){
    // no "this" reference for friendly out of scope calls
    if(defaults){
        OOJS.apply(o, defaults);
    }
    if(o && c && typeof c == 'object'){
        for(var p in c){
            o[p] = c[p];
        }
    }
    return o;
};

(function(){
    var idSeed = 0,
        toString = Object.prototype.toString,
        ua = navigator.userAgent.toLowerCase(),
        check = function(r){
            return r.test(ua);
        },
        DOC = document,
        docMode = DOC.documentMode,
        isStrict = DOC.compatMode == "CSS1Compat",
        isOpera = check(/opera/),
        isChrome = check(/\bchrome\b/),
        isWebKit = check(/webkit/),
        isSafari = !isChrome && check(/safari/),
        isSafari2 = isSafari && check(/applewebkit\/4/), // unique to Safari 2
        isSafari3 = isSafari && check(/version\/3/),
        isSafari4 = isSafari && check(/version\/4/),
        isIE = !isOpera && check(/msie/),
        isIE7 = isIE && ((check(/msie 7/) && docMode != 8 && docMode != 9 && docMode != 10) || docMode == 7),
        isIE8 = isIE && ((check(/msie 8/) && docMode != 7 && docMode != 9 && docMode != 10) || docMode == 8),
        isIE9 = isIE && ((check(/msie 9/) && docMode != 7 && docMode != 8 && docMode != 10) || docMode == 9),
        isIE10 = isIE && ((check(/msie 10/) && docMode != 7 && docMode != 8 && docMode != 9) || docMode == 10),
        isIE6 = isIE && check(/msie 6/),
        isIE9m = isIE && (isIE6 || isIE7 || isIE8 || isIE9),
        isGecko = !isWebKit && check(/gecko/),
        isGecko2 = isGecko && check(/rv:1\.8/),
        isGecko3 = isGecko && check(/rv:1\.9/),
        isBorderBox = isIE9m && !isStrict,
        isWindows = check(/windows|win32/),
        isMac = check(/macintosh|mac os x/),
        isAir = check(/adobeair/),
        isLinux = check(/linux/),
        isSecure = /^https/i.test(window.location.protocol),
        noArgs = [],
        nonEnumerables = [],
        emptyFn = OOJS.emptyFn,
        t = OOJS.apply({}, {
            constructor: emptyFn,
            toString: emptyFn,
            valueOf: emptyFn
        }),
        callOverrideParent = function () {
            var method = callOverrideParent.caller.caller; // skip callParent (our caller)
            return method.$owner.prototype[method.$name].apply(this, arguments);
        };

    if (t.constructor !== emptyFn) {
        nonEnumerables.push('constructor');
    }
    if (t.toString !== emptyFn) {
        nonEnumerables.push('toString');
    }
    if (t.valueOf !== emptyFn) {
        nonEnumerables.push('valueOf');
    }
    if (!nonEnumerables.length) {
        nonEnumerables = null;
    }

    // Create the abstract Base class to provide an empty constructor and callParent implementations
    function Base () {
        //
    }

    OOJS.apply(Base, {
        $isClass: true,

        callParent: function (args) {
            var method;

            // This code is intentionally inlined for the least number of debugger stepping
            return (method = this.callParent.caller) && (method.$previous ||
                ((method = method.$owner ? method : method.caller) &&
                        method.$owner.superclass.self[method.$name])).apply(this, args || noArgs);
        }
    });

    Base.prototype = {
        constructor: function() {
        },
        callParent: function(args) {
            // NOTE: this code is deliberately as few expressions (and no function calls)
            // as possible so that a debugger can skip over this noise with the minimum number
            // of steps. Basically, just hit Step Into until you are where you really wanted
            // to be.
            var method,
                superMethod = (method = this.callParent.caller) && (method.$previous ||
                        ((method = method.$owner ? method : method.caller) &&
                                method.$owner.superclass[method.$name]));

            return superMethod.apply(this, args || noArgs);
        }
    };

    // remove css image flicker
    if(isIE6){
        try{
            DOC.execCommand("BackgroundImageCache", false, true);
        }catch(e){}
    }

    OOJS.apply(OOJS, {
        /**
         * URL to a blank file used by OOJS when in secure mode for iframe src and onReady src to prevent
         * the IE insecure content warning (<tt>'about:blank'</tt>, except for IE in secure mode, which is <tt>'javascript:""'</tt>).
         * @type String
         */
        SSL_SECURE_URL : isSecure && isIE ? 'javascript:""' : 'about:blank',
        /**
         * True if the browser is in strict (standards-compliant) mode, as opposed to quirks mode
         * @type Boolean
         */
        isStrict : isStrict,
        /**
         * True if the page is running over SSL
         * @type Boolean
         */
        isSecure : isSecure,
        /**
         * True when the document is fully initialized and ready for action
         * @type Boolean
         */
        isReady : false,

        /**
         * True if the {@link OOJS.Fx} Class is available
         * @type Boolean
         * @property enableFx
         */

        /**
         * HIGHLY EXPERIMENTAL
         * True to force css based border-box model override and turning off javascript based adjustments. This is a
         * runtime configuration and must be set before onReady.
         * @type Boolean
         */
        enableForcedBoxModel : false,

        /**
         * True to automatically uncache orphaned OOJS.Elements periodically (defaults to true)
         * @type Boolean
         */
        enableGarbageCollector : true,

        /**
         * True to automatically purge event listeners during garbageCollection (defaults to false).
         * @type Boolean
         */
        enableListenerCollection : false,

        /**
         * EXPERIMENTAL - True to cascade listener removal to child elements when an element is removed.
         * Currently not optimized for performance.
         * @type Boolean
         */
        enableNestedListenerRemoval : false,

        /**
         * Indicates whether to use native browser parsing for JSON methods.
         * This option is ignored if the browser does not support native JSON methods.
         * <b>Note: Native JSON methods will not work with objects that have functions.
         * Also, property names must be quoted, otherwise the data will not parse.</b> (Defaults to false)
         * @type Boolean
         */
        USE_NATIVE_JSON : false,

        /**
         * Copies all the properties of config to obj if they don't already exist.
         * @param {Object} obj The receiver of the properties
         * @param {Object} config The source of the properties
         * @return {Object} returns obj
         */
        applyIf : function(o, c){
            if(o){
                for(var p in c){
                    if(!OOJS.isDefined(o[p])){
                        o[p] = c[p];
                    }
                }
            }
            return o;
        },

        /**
         * Generates unique ids. If the element already has an id, it is unchanged
         * @param {Mixed} el (optional) The element to generate an id for
         * @param {String} prefix (optional) Id prefix (defaults "ext-gen")
         * @return {String} The generated Id.
         */
        id : function(el, prefix){
            el = OOJS.getDom(el, true) || {};
            if (!el.id) {
                el.id = (prefix || "ext-gen") + (++idSeed);
            }
            return el.id;
        },

        /**
         * <p>Extends one class to create a subclass and optionally overrides members with the passed literal. This method
         * also adds the function "override()" to the subclass that can be used to override members of the class.</p>
         * For example, to create a subclass of OOJS GridPanel:
         * <pre><code>
MyGridPanel = OOJS.extend(OOJS.grid.GridPanel, {
    constructor: function(config) {

//      Create configuration for this Grid.
        var store = new OOJS.data.Store({...});
        var colModel = new OOJS.grid.ColumnModel({...});

//      Create a new config object containing our computed properties
//      *plus* whatever was in the config parameter.
        config = OOJS.apply({
            store: store,
            colModel: colModel
        }, config);

        MyGridPanel.superclass.constructor.call(this, config);

//      Your postprocessing here
    },

    yourMethod: function() {
        // etc.
    }
});
</code></pre>
         *
         * <p>This function also supports a 3-argument call in which the subclass's constructor is
         * passed as an argument. In this form, the parameters are as follows:</p>
         * <div class="mdetail-params"><ul>
         * <li><code>subclass</code> : Function <div class="sub-desc">The subclass constructor.</div></li>
         * <li><code>superclass</code> : Function <div class="sub-desc">The constructor of class being extended</div></li>
         * <li><code>overrides</code> : Object <div class="sub-desc">A literal with members which are copied into the subclass's
         * prototype, and are therefore shared among all instances of the new class.</div></li>
         * </ul></div>
         *
         * @param {Function} superclass The constructor of class being extended.
         * @param {Object} overrides <p>A literal with members which are copied into the subclass's
         * prototype, and are therefore shared between all instances of the new class.</p>
         * <p>This may contain a special member named <tt><b>constructor</b></tt>. This is used
         * to define the constructor of the new class, and is returned. If this property is
         * <i>not</i> specified, a constructor is generated and returned which just calls the
         * superclass's constructor passing on its parameters.</p>
         * <p><b>It is essential that you call the superclass constructor in any provided constructor. See example code.</b></p>
         * @return {Function} The subclass constructor from the <code>overrides</code> parameter, or a generated one if not provided.
         */
        extend : function(){
            // inline overrides
            var io = function(o){
                for(var m in o){
                    this[m] = o[m];
                }
            };
            var oc = Object.prototype.constructor;

            return function(sb, sp, overrides){
                if(typeof sp == 'object'){
                    overrides = sp;
                    sp = sb;
                    sb = overrides.constructor != oc ? overrides.constructor : function(){sp.apply(this, arguments);};
                }
                var F = function(){},
                    sbp,
                    spp = sp.prototype;

                F.prototype = spp;
                sbp = sb.prototype = new F();
                sbp.constructor=sb;
                sb.superclass=spp;
                if(spp.constructor == oc){
                    spp.constructor=sp;
                }
                sb.override = function(o){
                    OOJS.override(sb, o);
                };
                sbp.superclass = sbp.supr = (function(){
                    return spp;
                });
                sbp.override = io;
                OOJS.override(sb, overrides);
                sb.extend = function(o){return OOJS.extend(sb, o);};
                return sb;
            };
        }(),

        global: (function () {
            return this;
        })(),

        Base: Base,

        namespaceCache: {},

        createNamespace: function (namespaceOrClass, isClass) {
            var cache = OOJS.namespaceCache,
                namespace = isClass ? namespaceOrClass.substring(0, namespaceOrClass.lastIndexOf('.'))
                            : namespaceOrClass,
                ns = cache[namespace],
                i, n, part, parts, partials;

            if (!ns) {
                ns = OOJS.global;
                if (namespace) {
                    partials = [];
                    parts = namespace.split('.');

                    for (i = 0, n = parts.length; i < n; ++i) {
                        part = parts[i];

                        ns = ns[part] || (ns[part] = {});
                        partials.push(part);

                        cache[partials.join('.')] = ns; // build up prefixes as we go
                    }
                }
            }

            return ns;
        },

        getClassByName: function (className) {
            var parts = className.split('.'),
                cls = OOJS.global,
                n = parts.length,
                i;

            for (i = 0; cls && i < n; ++i) {
                cls = cls[parts[i]];
            }

            return cls || null;
        },

        addMembers: function (cls, target, members, handleNonEnumerables) {
            var i, name, member;

            for (name in members) {
                if (members.hasOwnProperty(name)) {
                    member = members[name];
                    if (typeof member == 'function') {
                        member.$owner = cls;
                        member.$name = name;
                    }

                    target[name] = member;
                }
            }

            if (handleNonEnumerables && nonEnumerables) {
                for (i = nonEnumerables.length; i-- > 0; ) {
                    name = nonEnumerables[i];
                    if (members.hasOwnProperty(name)) {
                        member = members[name];
                        if (typeof member == 'function') {
                            member.$owner = cls;
                            member.$name = name;
                        }

                        target[name] = member;
                    }
                }
            }
        },

        /**
         * @method
         * Defines a class or override. A basic class is defined like this:
         *
         *      OOJS.define('My.awesome.Class', {
         *          someProperty: 'something',
         *
         *          someMethod: function(s) {
         *              alert(s + this.someProperty);
         *          }
         *
         *          ...
         *      });
         *
         *      var obj = new My.awesome.Class();
         *
         *      obj.someMethod('Say '); // alerts 'Say something'
         *
         * To create an anonymous class, pass `null` for the `className`:
         * 
         *      OOJS.define(null, {
         *          constructor: function () {
         *              // ...
         *          }
         *      });
         *
         * In some cases, it is helpful to create a nested scope to contain some private
         * properties. The best way to do this is to pass a function instead of an object
         * as the second parameter. This function will be called to produce the class
         * body:
         * 
         *      OOJS.define('MyApp.foo.Bar', function () {
         *          var id = 0;
         *          
         *          return {
         *              nextId: function () {
         *                  return ++id;
         *              }
         *          };
         *      });
         * 
         * When using this form of `OOJS.define`, the function is passed a reference to its
         * class. This can be used as an efficient way to access any static properties you
         * may have:
         * 
         *      OOJS.define('MyApp.foo.Bar', function (Bar) {
         *          return {
         *              statics: {
         *                  staticMethod: function () {
         *                      // ...
         *                  }
         *              },
         *              
         *              method: function () {
         *                  return Bar.staticMethod();
         *              }
         *          };
         *      });
         *
         * To define an override, include the `override` property. The content of an
         * override is aggregated with the specified class in order to extend or modify
         * that class. This can be as simple as setting default property values or it can
         * extend and/or replace methods. This can also extend the statics of the class.
         *
         * One use for an override is to break a large class into manageable pieces.
         *
         *      // File: /src/app/Panel.js
         *
         *      OOJS.define('My.app.Panel', {
         *          extend: 'OOJS.panel.Panel',
         *
         *          constructor: function (config) {
         *              this.callParent(arguments); // calls OOJS.panel.Panel's constructor
         *              //...
         *          },
         *
         *          statics: {
         *              method: function () {
         *                  return 'abc';
         *              }
         *          }
         *      });
         *
         *      // File: /src/app/PanelPart2.js
         *      OOJS.define('My.app.PanelPart2', {
         *          override: 'My.app.Panel',
         *
         *          constructor: function (config) {
         *              this.callParent(arguments); // calls My.app.Panel's constructor
         *              //...
         *          }
         *      });
         *
         * Another use of overrides is to provide optional parts of classes that can be
         * independently required. In this case, the class may even be unaware of the
         * override altogether.
         *
         *      OOJS.define('My.ux.CoolTip', {
         *          override: 'OOJS.tip.ToolTip',
         *
         *          constructor: function (config) {
         *              this.callParent(arguments); // calls OOJS.tip.ToolTip's constructor
         *              //...
         *          }
         *      });
         *
         * Overrides can also contain statics:
         *
         *      OOJS.define('My.app.BarMod', {
         *          override: 'OOJS.foo.Bar',
         *
         *          statics: {
         *              method: function (x) {
         *                  return this.callParent([x * 2]); // call OOJS.foo.Bar.method
         *              }
         *          }
         *      });
         *
         * @param {String} className The class name to create in string dot-namespaced format, for example:
         * 'My.very.awesome.Class', 'FeedViewer.plugin.CoolPager'
         * It is highly recommended to follow this simple convention:
         *  - The root and the class name are 'CamelCased'
         *  - Everything else is lower-cased
         * Pass `null` to create an anonymous class.
         * @param {Object} data The key - value pairs of properties to apply to this class. Property names can be of any valid
         * strings, except those in the reserved listed below:
         *  - `mixins`
         *  - `statics`
         *  - `config`
         *  - `alias`
         *  - `self`
         *  - `singleton`
         *  - `alternateClassName`
         *  - `override`
         *
         * @param {Function} createdFn Optional callback to execute after the class is created, the execution scope of which
         * (`this`) will be the newly created class itself.
         * @return {OOJS.Base}
         * @markdown
         * @member OOJS
         * @method define
         */
        define: function (className, body, createdFn) {
            var override = body.override,
                cls, extend, name, namespace;

            if (override) {
                delete body.override;
                cls = OOJS.getClassByName(override);
                OOJS.override(cls, body);
            } else {
                if (className) {
                    namespace = OOJS.createNamespace(className, true);
                    name = className.substring(className.lastIndexOf('.')+1);
                }

                cls = function ctor () {
                    this.constructor.apply(this, arguments);
                }

                if (className) {
                    cls.displayName = className;
                }
                cls.$isClass = true;
                cls.callParent = OOJS.Base.callParent;

                if (typeof body == 'function') {
                    body = body(cls);
                }

                extend = body.extend;
                if (extend) {
                    delete body.extend;
                    if (typeof extend == 'string') {
                        extend = OOJS.getClassByName(extend);
                    }
                } else {
                    extend = Base;
                }

                OOJS.extend(cls, extend, body);
                if (cls.prototype.constructor === cls) {
                    delete cls.prototype.constructor;
                }

                // Not extending a class which derives from Base...
                if (!cls.prototype.$isClass) {
                    OOJS.applyIf(cls.prototype, Base.prototype);
                }
                cls.prototype.self = cls;
                
                if (body.xtype) {
                    OOJS.reg(body.xtype, cls);
                }
                cls = body.singleton ? new cls() : cls;
                if (className) {
                    namespace[name] = cls;
                }
            }

            if (createdFn) {
                createdFn.call(cls);
            }

            return cls;
        },

        /**
         * Overrides members of the specified `target` with the given values.
         *
         * If the `target` is a function, it is assumed to be a constructor and the contents
         * of `overrides` are applied to its `prototype` using {@link OOJS#apply OOJS.apply}.
         * 
         * If the `target` is an instance of a class created using {@link #define},
         * the `overrides` are applied to only that instance. In this case, methods are
         * specially processed to allow them to use {@link OOJS.Base#callParent}.
         * 
         *      var panel = new OOJS.Panel({ ... });
         *      
         *      OOJS.override(panel, {
         *          initComponent: function () {
         *              // extra processing...
         *              
         *              this.callParent();
         *          }
         *      });
         *
         * If the `target` is none of these, the `overrides` are applied to the `target`
         * using {@link OOJS#apply OOJS.apply}.
         *
         * Please refer to {@link OOJS#define OOJS.define} for further details.
         *
         * @param {Object} target The target to override.
         * @param {Object} overrides The properties to add or replace on `target`. 
         * @method override
         */
        override: function (target, overrides) {
            var proto, statics;

            if (overrides) {
                if (target.$isClass) {
                    statics = overrides.statics;
                    if (statics) {
                        delete overrides.statics;
                    }

                    OOJS.addMembers(target, target.prototype, overrides, true);
                    if (statics) {
                        OOJS.addMembers(target, target, statics);
                    }
                } else if (typeof target == 'function') {
                    proto = target.prototype;
                    OOJS.apply(proto, overrides);
                    if(OOJS.isIE && overrides.hasOwnProperty('toString')){
                        proto.toString = overrides.toString;
                    }
                } else {
                    var owner = target.self,
                        name, value;

                    if (owner && owner.$isClass) {
                        for (name in overrides) {
                            if (overrides.hasOwnProperty(name)) {
                                value = overrides[name];

                                if (typeof value == 'function') {
                                    //<debug>
                                    if (owner.$className) {
                                        value.displayName = owner.$className + '#' + name;
                                    }
                                    //</debug>

                                    value.$name = name;
                                    value.$owner = owner;
                                    value.$previous = target.hasOwnProperty(name)
                                        ? target[name] // already hooked, so call previous hook
                                        : callOverrideParent; // calls by name on prototype
                                }

                                target[name] = value;
                            }
                        }
                    } else {
                        OOJS.apply(target, overrides);

                        if (!target.constructor.$isClass) {
                            target.constructor.prototype.callParent = Base.prototype.callParent;
                            target.constructor.callParent = Base.callParent;
                        }
                    }
                }
            }
        },

        /**
         * Creates namespaces to be used for scoping variables and classes so that they are not global.
         * Specifying the last node of a namespace implicitly creates all other nodes. Usage:
         * <pre><code>
OOJS.namespace('Company', 'Company.data');
OOJS.namespace('Company.data'); // equivalent and preferable to above syntax
Company.Widget = function() { ... }
Company.data.CustomStore = function(config) { ... }
</code></pre>
         * @param {String} namespace1
         * @param {String} namespace2
         * @param {String} etc
         * @return {Object} The namespace object. (If multiple arguments are passed, this will be the last namespace created)
         * @method namespace
         */
        namespace : function(){
            var len1 = arguments.length,
                i = 0,
                len2,
                j,
                main,
                ns,
                sub,
                current;

            for(; i < len1; ++i) {
                main = arguments[i];
                ns = arguments[i].split('.');
                current = window[ns[0]];
                if (current === undefined) {
                    current = window[ns[0]] = {};
                }
                sub = ns.slice(1);
                len2 = sub.length;
                for(j = 0; j < len2; ++j) {
                    current = current[sub[j]] = current[sub[j]] || {};
                }
            }
            return current;
        },

        /**
         * Takes an object and converts it to an encoded URL. e.g. OOJS.urlEncode({foo: 1, bar: 2}); would return "foo=1&bar=2".  Optionally, property values can be arrays, instead of keys and the resulting string that's returned will contain a name/value pair for each array value.
         * @param {Object} o
         * @param {String} pre (optional) A prefix to add to the url encoded string
         * @return {String}
         */
        urlEncode : function(o, pre){
            var empty,
                buf = [],
                e = encodeURIComponent;

            OOJS.iterate(o, function(key, item){
                empty = OOJS.isEmpty(item);
                OOJS.each(empty ? key : item, function(val){
                    buf.push('&', e(key), '=', (!OOJS.isEmpty(val) && (val != key || !empty)) ? (OOJS.isDate(val) ? OOJS.encode(val).replace(/"/g, '') : e(val)) : '');
                });
            });
            if(!pre){
                buf.shift();
                pre = '';
            }
            return pre + buf.join('');
        },

        /**
         * Takes an encoded URL and and converts it to an object. Example: <pre><code>
OOJS.urlDecode("foo=1&bar=2"); // returns {foo: "1", bar: "2"}
OOJS.urlDecode("foo=1&bar=2&bar=3&bar=4", false); // returns {foo: "1", bar: ["2", "3", "4"]}
</code></pre>
         * @param {String} string
         * @param {Boolean} overwrite (optional) Items of the same name will overwrite previous values instead of creating an an array (Defaults to false).
         * @return {Object} A literal with members
         */
        urlDecode : function(string, overwrite){
            if(OOJS.isEmpty(string)){
                return {};
            }
            var obj = {},
                pairs = string.split('&'),
                d = decodeURIComponent,
                name,
                value;
            OOJS.each(pairs, function(pair) {
                pair = pair.split('=');
                name = d(pair[0]);
                value = d(pair[1]);
                obj[name] = overwrite || !obj[name] ? value :
                            [].concat(obj[name]).concat(value);
            });
            return obj;
        },

        /**
         * Appends content to the query string of a URL, handling logic for whether to place
         * a question mark or ampersand.
         * @param {String} url The URL to append to.
         * @param {String} s The content to append to the URL.
         * @return (String) The resulting URL
         */
        urlAppend : function(url, s){
            if(!OOJS.isEmpty(s)){
                return url + (url.indexOf('?') === -1 ? '?' : '&') + s;
            }
            return url;
        },

        /**
         * Converts any iterable (numeric indices and a length property) into a true array
         * Don't use this on strings. IE doesn't support "abc"[0] which this implementation depends on.
         * For strings, use this instead: "abc".match(/./g) => [a,b,c];
         * @param {Iterable} the iterable object to be turned into a true Array.
         * @return (Array) array
         */
         toArray : function(){
             return isIE ?
                 function(a, i, j, res){
                     res = [];
                     for(var x = 0, len = a.length; x < len; x++) {
                         res.push(a[x]);
                     }
                     return res.slice(i || 0, j || res.length);
                 } :
                 function(a, i, j){
                     return Array.prototype.slice.call(a, i || 0, j || a.length);
                 };
         }(),

        isIterable : function(v){
            //check for array or arguments
            if(OOJS.isArray(v) || v.callee){
                return true;
            }
            //check for node list type
            if(/NodeList|HTMLCollection/.test(toString.call(v))){
                return true;
            }
            //NodeList has an item and length property
            //IXMLDOMNodeList has nextNode method, needs to be checked first.
            return ((typeof v.nextNode != 'undefined' || v.item) && OOJS.isNumber(v.length));
        },

        /**
         * Iterates an array calling the supplied function.
         * @param {Array/NodeList/Mixed} array The array to be iterated. If this
         * argument is not really an array, the supplied function is called once.
         * @param {Function} fn The function to be called with each item. If the
         * supplied function returns false, iteration stops and this method returns
         * the current <code>index</code>. This function is called with
         * the following arguments:
         * <div class="mdetail-params"><ul>
         * <li><code>item</code> : <i>Mixed</i>
         * <div class="sub-desc">The item at the current <code>index</code>
         * in the passed <code>array</code></div></li>
         * <li><code>index</code> : <i>Number</i>
         * <div class="sub-desc">The current index within the array</div></li>
         * <li><code>allItems</code> : <i>Array</i>
         * <div class="sub-desc">The <code>array</code> passed as the first
         * argument to <code>OOJS.each</code>.</div></li>
         * </ul></div>
         * @param {Object} scope The scope (<code>this</code> reference) in which the specified function is executed.
         * Defaults to the <code>item</code> at the current <code>index</code>
         * within the passed <code>array</code>.
         * @return See description for the fn parameter.
         */
        each : function(array, fn, scope){
            if(OOJS.isEmpty(array, true)){
                return;
            }
            if(!OOJS.isIterable(array) || OOJS.isPrimitive(array)){
                array = [array];
            }
            for(var i = 0, len = array.length; i < len; i++){
                if(fn.call(scope || array[i], array[i], i, array) === false){
                    return i;
                };
            }
        },

        /**
         * Iterates either the elements in an array, or each of the properties in an object.
         * <b>Note</b>: If you are only iterating arrays, it is better to call {@link #each}.
         * @param {Object/Array} object The object or array to be iterated
         * @param {Function} fn The function to be called for each iteration.
         * The iteration will stop if the supplied function returns false, or
         * all array elements / object properties have been covered. The signature
         * varies depending on the type of object being interated:
         * <div class="mdetail-params"><ul>
         * <li>Arrays : <tt>(Object item, Number index, Array allItems)</tt>
         * <div class="sub-desc">
         * When iterating an array, the supplied function is called with each item.</div></li>
         * <li>Objects : <tt>(String key, Object value, Object)</tt>
         * <div class="sub-desc">
         * When iterating an object, the supplied function is called with each key-value pair in
         * the object, and the iterated object</div></li>
         * </ul></div>
         * @param {Object} scope The scope (<code>this</code> reference) in which the specified function is executed. Defaults to
         * the <code>object</code> being iterated.
         */
        iterate : function(obj, fn, scope){
            if(OOJS.isEmpty(obj)){
                return;
            }
            if(OOJS.isIterable(obj)){
            	OOJS.each(obj, fn, scope);
                return;
            }else if(typeof obj == 'object'){
                for(var prop in obj){
                    if(obj.hasOwnProperty(prop)){
                        if(fn.call(scope || obj, prop, obj[prop], obj) === false){
                            return;
                        };
                    }
                }
            }
        },

        /**
         * Return the dom node for the passed String (id), dom node, or OOJS.Element.
         * Optional 'strict' flag is needed for IE since it can return 'name' and
         * 'id' elements by using getElementById.
         * Here are some examples:
         * <pre><code>
// gets dom node based on id
var elDom = OOJS.getDom('elId');
// gets dom node based on the dom node
var elDom1 = OOJS.getDom(elDom);

// If we don&#39;t know if we are working with an
// OOJS.Element or a dom node use OOJS.getDom
function(el){
    var dom = OOJS.getDom(el);
    // do something with the dom node
}
         * </code></pre>
         * <b>Note</b>: the dom node to be found actually needs to exist (be rendered, etc)
         * when this method is called to be successful.
         * @param {Mixed} el
         * @return HTMLElement
         */
        getDom : function(el, strict){
            if(!el || !DOC){
                return null;
            }
            if (el.dom){
                return el.dom;
            } else {
                if (typeof el == 'string') {
                    var e = DOC.getElementById(el);
                    // IE returns elements with the 'name' and 'id' attribute.
                    // we do a strict check to return the element with only the id attribute
                    if (e && isIE && strict) {
                        if (el == e.getAttribute('id')) {
                            return e;
                        } else {
                            return null;
                        }
                    }
                    return e;
                } else {
                    return el;
                }
            }
        },

        /**
         * Returns the current document body as an {@link OOJS.Element}.
         * @return OOJS.Element The document body
         */
        getBody : function(){
            return OOJS.get(DOC.body || DOC.documentElement);
        },

        /**
         * Returns the current document body as an {@link OOJS.Element}.
         * @return OOJS.Element The document body
         * @method
         */
        getHead : function() {
            var head;

            return function() {
                if (head == undefined) {
                    head = OOJS.get(DOC.getElementsByTagName("head")[0]);
                }

                return head;
            };
        }(),

        /**
         * <p>Removes this element from the document, removes all DOM event listeners, and deletes the cache reference.
         * All DOM event listeners are removed from this element. If {@link OOJS#enableNestedListenerRemoval} is
         * <code>true</code>, then DOM event listeners are also removed from all child nodes. The body node
         * will be ignored if passed in.</p>
         * @param {HTMLElement} node The node to remove
         * @method
         */
        removeNode : isIE && !isIE8 ? function(){
            var d;
            return function(n){
                if(n && n.tagName != 'BODY'){
                    (OOJS.enableNestedListenerRemoval) ? OOJS.EventManager.purgeElement(n, true) : OOJS.EventManager.removeAll(n);
                    d = d || DOC.createElement('div');
                    d.appendChild(n);
                    d.innerHTML = '';
                    delete OOJS.elCache[n.id];
                }
            };
        }() : function(n){
            if(n && n.parentNode && n.tagName != 'BODY'){
                (OOJS.enableNestedListenerRemoval) ? OOJS.EventManager.purgeElement(n, true) : OOJS.EventManager.removeAll(n);
                n.parentNode.removeChild(n);
                delete OOJS.elCache[n.id];
            }
        },

        /**
         * <p>Returns true if the passed value is empty.</p>
         * <p>The value is deemed to be empty if it is<div class="mdetail-params"><ul>
         * <li>null</li>
         * <li>undefined</li>
         * <li>an empty array</li>
         * <li>a zero length string (Unless the <tt>allowBlank</tt> parameter is <tt>true</tt>)</li>
         * </ul></div>
         * @param {Mixed} value The value to test
         * @param {Boolean} allowBlank (optional) true to allow empty strings (defaults to false)
         * @return {Boolean}
         */
        isEmpty : function(v, allowBlank){
            return v === null || v === undefined || ((OOJS.isArray(v) && !v.length)) || (!allowBlank ? v === '' : false);
        },

        /**
         * Returns true if the passed value is a JavaScript array, otherwise false.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isArray : function(v){
            return toString.apply(v) === '[object Array]';
        },

        /**
         * Returns true if the passed object is a JavaScript date object, otherwise false.
         * @param {Object} object The object to test
         * @return {Boolean}
         */
        isDate : function(v){
            return toString.apply(v) === '[object Date]';
        },

        /**
         * Returns true if the passed value is a JavaScript Object, otherwise false.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isObject : function(v){
            return !!v && Object.prototype.toString.call(v) === '[object Object]';
        },

        /**
         * Returns true if the passed value is a JavaScript 'primitive', a string, number or boolean.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isPrimitive : function(v){
            return OOJS.isString(v) || OOJS.isNumber(v) || OOJS.isBoolean(v);
        },

        /**
         * Returns true if the passed value is a JavaScript Function, otherwise false.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isFunction : function(v){
            return toString.apply(v) === '[object Function]';
        },

        /**
         * Returns true if the passed value is a number. Returns false for non-finite numbers.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isNumber : function(v){
            return typeof v === 'number' && isFinite(v);
        },

        /**
         * Returns true if the passed value is a string.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isString : function(v){
            return typeof v === 'string';
        },

        /**
         * Returns true if the passed value is a boolean.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isBoolean : function(v){
            return typeof v === 'boolean';
        },

        /**
         * Returns true if the passed value is an HTMLElement
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isElement : function(v) {
            return v ? !!v.tagName : false;
        },

        /**
         * Returns true if the passed value is not undefined.
         * @param {Mixed} value The value to test
         * @return {Boolean}
         */
        isDefined : function(v){
            return typeof v !== 'undefined';
        },

        /**
         * True if the detected browser is Opera.
         * @type Boolean
         */
        isOpera : isOpera,
        /**
         * True if the detected browser uses WebKit.
         * @type Boolean
         */
        isWebKit : isWebKit,
        /**
         * True if the detected browser is Chrome.
         * @type Boolean
         */
        isChrome : isChrome,
        /**
         * True if the detected browser is Safari.
         * @type Boolean
         */
        isSafari : isSafari,
        /**
         * True if the detected browser is Safari 3.x.
         * @type Boolean
         */
        isSafari3 : isSafari3,
        /**
         * True if the detected browser is Safari 4.x.
         * @type Boolean
         */
        isSafari4 : isSafari4,
        /**
         * True if the detected browser is Safari 2.x.
         * @type Boolean
         */
        isSafari2 : isSafari2,
        /**
         * True if the detected browser is Internet Explorer.
         * @type Boolean
         */
        isIE : isIE,
        /**
         * True if the detected browser is Internet Explorer 6.x.
         * @type Boolean
         */
        isIE6 : isIE6,
        /**
         * True if the detected browser is Internet Explorer 7.x.
         * @type Boolean
         */
        isIE7 : isIE7,
        /**
         * True if the detected browser is Internet Explorer 8.x.
         * @type Boolean
         */
        isIE8 : isIE8,
        /**
         * True if the detected browser is Internet Explorer 9.x.
         * @type Boolean
         */
        isIE9 : isIE9,
        
        /**
         * True if the detected browser is Internet Explorer 10.x
         * @type Boolean
         */
        isIE10 : isIE10,
        
        /**
         * True if the detected browser is Internet Explorer 9.x or lower
         * @type Boolean
         */
        isIE9m : isIE9m,
        
        /**
         * True if the detected browser is Internet Explorer 10.x or higher
         * @type Boolean
         */ 
        isIE10p : isIE && !(isIE6 || isIE7 || isIE8 || isIE9),
        
        // IE10 quirks behaves like Gecko/WebKit quirks, so don't include it here
        // Used internally
        isIEQuirks: isIE && (!isStrict && (isIE6 || isIE7 || isIE8 || isIE9)),
                
        /**
         * True if the detected browser uses the Gecko layout engine (e.g. Mozilla, Firefox).
         * @type Boolean
         */
        isGecko : isGecko,
        /**
         * True if the detected browser uses a pre-Gecko 1.9 layout engine (e.g. Firefox 2.x).
         * @type Boolean
         */
        isGecko2 : isGecko2,
        /**
         * True if the detected browser uses a Gecko 1.9+ layout engine (e.g. Firefox 3.x).
         * @type Boolean
         */
        isGecko3 : isGecko3,
        /**
         * True if the detected browser is Internet Explorer running in non-strict mode.
         * @type Boolean
         */
        isBorderBox : isBorderBox,
        /**
         * True if the detected platform is Linux.
         * @type Boolean
         */
        isLinux : isLinux,
        /**
         * True if the detected platform is Windows.
         * @type Boolean
         */
        isWindows : isWindows,
        /**
         * True if the detected platform is Mac OS.
         * @type Boolean
         */
        isMac : isMac,
        /**
         * True if the detected platform is Adobe Air.
         * @type Boolean
         */
        isAir : isAir
    });

    /**
     * Creates namespaces to be used for scoping variables and classes so that they are not global.
     * Specifying the last node of a namespace implicitly creates all other nodes. Usage:
     * <pre><code>
OOJS.namespace('Company', 'Company.data');
OOJS.namespace('Company.data'); // equivalent and preferable to above syntax
Company.Widget = function() { ... }
Company.data.CustomStore = function(config) { ... }
</code></pre>
     * @param {String} namespace1
     * @param {String} namespace2
     * @param {String} etc
     * @return {Object} The namespace object. (If multiple arguments are passed, this will be the last namespace created)
     * @method ns
     */
    OOJS.ns = OOJS.namespace;
})();

OOJS.ns('OOJS.util', 'OOJS.lib', 'OOJS.data', 'OOJS.supports');

OOJS.elCache = {};

/**
 * @class Function
 * These functions are available on every Function object (any JavaScript function).
 */
OOJS.apply(Function.prototype, {
     /**
     * Creates an interceptor function. The passed function is called before the original one. If it returns false,
     * the original one is not called. The resulting function returns the results of the original function.
     * The passed function is called with the parameters of the original function. Example usage:
     * <pre><code>
var sayHi = function(name){
    alert('Hi, ' + name);
}

sayHi('Fred'); // alerts "Hi, Fred"

// create a new function that validates input without
// directly modifying the original function:
var sayHiToFriend = sayHi.createInterceptor(function(name){
    return name == 'Brian';
});

sayHiToFriend('Fred');  // no alert
sayHiToFriend('Brian'); // alerts "Hi, Brian"
</code></pre>
     * @param {Function} fcn The function to call before the original
     * @param {Object} scope (optional) The scope (<code><b>this</b></code> reference) in which the passed function is executed.
     * <b>If omitted, defaults to the scope in which the original function is called or the browser window.</b>
     * @return {Function} The new function
     */
    createInterceptor : function(fcn, scope){
        var method = this;
        return !OOJS.isFunction(fcn) ?
                this :
                function() {
                    var me = this,
                        args = arguments;
                    fcn.target = me;
                    fcn.method = method;
                    return (fcn.apply(scope || me || window, args) !== false) ?
                            method.apply(me || window, args) :
                            null;
                };
    },

     /**
     * Creates a callback that passes arguments[0], arguments[1], arguments[2], ...
     * Call directly on any function. Example: <code>myFunction.createCallback(arg1, arg2)</code>
     * Will create a function that is bound to those 2 args. <b>If a specific scope is required in the
     * callback, use {@link #createDelegate} instead.</b> The function returned by createCallback always
     * executes in the window scope.
     * <p>This method is required when you want to pass arguments to a callback function.  If no arguments
     * are needed, you can simply pass a reference to the function as a callback (e.g., callback: myFn).
     * However, if you tried to pass a function with arguments (e.g., callback: myFn(arg1, arg2)) the function
     * would simply execute immediately when the code is parsed. Example usage:
     * <pre><code>
var sayHi = function(name){
    alert('Hi, ' + name);
}

// clicking the button alerts "Hi, Fred"
new OOJS.Button({
    text: 'Say Hi',
    renderTo: OOJS.getBody(),
    handler: sayHi.createCallback('Fred')
});
</code></pre>
     * @return {Function} The new function
    */
    createCallback : function(/*args...*/){
        // make args available, in function below
        var args = arguments,
            method = this;
        return function() {
            return method.apply(window, args);
        };
    },

    /**
     * Creates a delegate (callback) that sets the scope to obj.
     * Call directly on any function. Example: <code>this.myFunction.createDelegate(this, [arg1, arg2])</code>
     * Will create a function that is automatically scoped to obj so that the <tt>this</tt> variable inside the
     * callback points to obj. Example usage:
     * <pre><code>
var sayHi = function(name){
    // Note this use of "this.text" here.  This function expects to
    // execute within a scope that contains a text property.  In this
    // example, the "this" variable is pointing to the btn object that
    // was passed in createDelegate below.
    alert('Hi, ' + name + '. You clicked the "' + this.text + '" button.');
}

var btn = new OOJS.Button({
    text: 'Say Hi',
    renderTo: OOJS.getBody()
});

// This callback will execute in the scope of the
// button instance. Clicking the button alerts
// "Hi, Fred. You clicked the "Say Hi" button."
btn.on('click', sayHi.createDelegate(btn, ['Fred']));
</code></pre>
     * @param {Object} scope (optional) The scope (<code><b>this</b></code> reference) in which the function is executed.
     * <b>If omitted, defaults to the browser window.</b>
     * @param {Array} args (optional) Overrides arguments for the call. (Defaults to the arguments passed by the caller)
     * @param {Boolean/Number} appendArgs (optional) if True args are appended to call args instead of overriding,
     * if a number the args are inserted at the specified position
     * @return {Function} The new function
     */
    createDelegate : function(obj, args, appendArgs){
        var method = this;
        return function() {
            var callArgs = args || arguments;
            if (appendArgs === true){
                callArgs = Array.prototype.slice.call(arguments, 0);
                callArgs = callArgs.concat(args);
            }else if (OOJS.isNumber(appendArgs)){
                callArgs = Array.prototype.slice.call(arguments, 0); // copy arguments first
                var applyArgs = [appendArgs, 0].concat(args); // create method call params
                Array.prototype.splice.apply(callArgs, applyArgs); // splice them in
            }
            return method.apply(obj || window, callArgs);
        };
    },

    /**
     * Calls this function after the number of millseconds specified, optionally in a specific scope. Example usage:
     * <pre><code>
var sayHi = function(name){
    alert('Hi, ' + name);
}

// executes immediately:
sayHi('Fred');

// executes after 2 seconds:
sayHi.defer(2000, this, ['Fred']);

// this syntax is sometimes useful for deferring
// execution of an anonymous function:
(function(){
    alert('Anonymous');
}).defer(100);
</code></pre>
     * @param {Number} millis The number of milliseconds for the setTimeout call (if less than or equal to 0 the function is executed immediately)
     * @param {Object} scope (optional) The scope (<code><b>this</b></code> reference) in which the function is executed.
     * <b>If omitted, defaults to the browser window.</b>
     * @param {Array} args (optional) Overrides arguments for the call. (Defaults to the arguments passed by the caller)
     * @param {Boolean/Number} appendArgs (optional) if True args are appended to call args instead of overriding,
     * if a number the args are inserted at the specified position
     * @return {Number} The timeout id that can be used with clearTimeout
     */
    defer : function(millis, obj, args, appendArgs){
        var fn = this.createDelegate(obj, args, appendArgs);
        if(millis > 0){
            return setTimeout(fn, millis);
        }
        fn();
        return 0;
    }
});

/**
 * @class String
 * These functions are available on every String object.
 */
OOJS.applyIf(String, {
    /**
     * Allows you to define a tokenized string and pass an arbitrary number of arguments to replace the tokens.  Each
     * token must be unique, and must increment in the format {0}, {1}, etc.  Example usage:
     * <pre><code>
var cls = 'my-class', text = 'Some text';
var s = String.format('&lt;div class="{0}">{1}&lt;/div>', cls, text);
// s now contains the string: '&lt;div class="my-class">Some text&lt;/div>'
     * </code></pre>
     * @param {String} string The tokenized string to be formatted
     * @param {String} value1 The value to replace token {0}
     * @param {String} value2 Etc...
     * @return {String} The formatted string
     * @static
     */
    format : function(format){
        var args = OOJS.toArray(arguments, 1);
        return format.replace(/\{(\d+)\}/g, function(m, i){
            return args[i];
        });
    }
});

/**
 * @class Array
 */
OOJS.applyIf(Array.prototype, {
    /**
     * Checks whether or not the specified object exists in the array.
     * @param {Object} o The object to check for
     * @param {Number} from (Optional) The index at which to begin the search
     * @return {Number} The index of o in the array (or -1 if it is not found)
     */
    indexOf : function(o, from){
        var len = this.length;
        from = from || 0;
        from += (from < 0) ? len : 0;
        for (; from < len; ++from){
            if(this[from] === o){
                return from;
            }
        }
        return -1;
    },

    /**
     * Removes the specified object from the array.  If the object is not found nothing happens.
     * @param {Object} o The object to remove
     * @return {Array} this array
     */
    remove : function(o){
        var index = this.indexOf(o);
        if(index != -1){
            this.splice(index, 1);
        }
        return this;
    }
});


/**************
 * Ext more   *
 **************/



/**
 * @class Ext
 */

//OOJS.ns("Ext.grid", "Ext.list", "Ext.dd", "Ext.tree", "Ext.form", "Ext.menu",
//       "Ext.state", "Ext.layout.boxOverflow", "Ext.app", "Ext.ux", "Ext.chart", "Ext.direct", "Ext.slider");
    /**
     * Namespace alloted for extensions to the framework.
     * @property ux
     * @type Object
     */

OOJS.apply(OOJS, function(){
    var E = OOJS,
        idSeed = 0,
        scrollWidth = null;

    return {
        /**
        * A reusable empty function
        * @property
        * @type Function
        */
        emptyFn : function(){},

        /**
         * URL to a 1x1 transparent gif image used by Ext to create inline icons with CSS background images.
         * In older versions of IE, this defaults to "http://extjs.com/s.gif" and you should change this to a URL on your server.
         * For other browsers it uses an inline data URL.
         * @type String
         */
        //BLANK_IMAGE_URL : Ext.isIE6 || Ext.isIE7 || Ext.isAir ?
        //                    'http:/' + '/www.extjs.com/s.gif' :
        //                    'data:image/gif;base64,R0lGODlhAQABAID/AMDAwAAAACH5BAEAAAAALAAAAAABAAEAAAICRAEAOw==',

        extendX : function(supr, fn){
            return OOJS.extend(supr, fn(supr.prototype));
        },

        /**
         * Returns the current HTML document object as an {@link Ext.Element}.
         * @return Ext.Element The document
         */
        getDoc : function(){
            return OOJS.get(document);
        },

        /**
         * Utility method for validating that a value is numeric, returning the specified default value if it is not.
         * @param {Mixed} value Should be a number, but any type will be handled appropriately
         * @param {Number} defaultValue The value to return if the original value is non-numeric
         * @return {Number} Value, if numeric, else defaultValue
         */
        num : function(v, defaultValue){
            v = Number(OOJS.isEmpty(v) || OOJS.isArray(v) || typeof v == 'boolean' || (typeof v == 'string' && v.trim().length == 0) ? NaN : v);
            return isNaN(v) ? defaultValue : v;
        },

        /**
         * <p>Utility method for returning a default value if the passed value is empty.</p>
         * <p>The value is deemed to be empty if it is<div class="mdetail-params"><ul>
         * <li>null</li>
         * <li>undefined</li>
         * <li>an empty array</li>
         * <li>a zero length string (Unless the <tt>allowBlank</tt> parameter is <tt>true</tt>)</li>
         * </ul></div>
         * @param {Mixed} value The value to test
         * @param {Mixed} defaultValue The value to return if the original value is empty
         * @param {Boolean} allowBlank (optional) true to allow zero length strings to qualify as non-empty (defaults to false)
         * @return {Mixed} value, if non-empty, else defaultValue
         */
        value : function(v, defaultValue, allowBlank){
            return OOJS.isEmpty(v, allowBlank) ? defaultValue : v;
        },

        /**
         * Escapes the passed string for use in a regular expression
         * @param {String} str
         * @return {String}
         */
        escapeRe : function(s) {
            return s.replace(/([-.*+?^${}()|[\]\/\\])/g, "\\$1");
        },

        sequence : function(o, name, fn, scope){
            o[name] = o[name].createSequence(fn, scope);
        },

        /**
         * Applies event listeners to elements by selectors when the document is ready.
         * The event name is specified with an <tt>&#64;</tt> suffix.
         * <pre><code>
Ext.addBehaviors({
    // add a listener for click on all anchors in element with id foo
    '#foo a&#64;click' : function(e, t){
        // do something
    },

    // add the same listener to multiple selectors (separated by comma BEFORE the &#64;)
    '#foo a, #bar span.some-class&#64;mouseover' : function(){
        // do something
    }
});
         * </code></pre>
         * @param {Object} obj The list of behaviors to apply
         */
        addBehaviors : function(o){
            if(!OOJS.isReady){
                OOJS.onReady(function(){
                    OOJS.addBehaviors(o);
                });
            } else {
                var cache = {}, // simple cache for applying multiple behaviors to same selector does query multiple times
                    parts,
                    b,
                    s;
                for (b in o) {
                    if ((parts = b.split('@'))[1]) { // for Object prototype breakers
                        s = parts[0];
                        if(!cache[s]){
                            cache[s] = OOJS.select(s);
                        }
                        cache[s].on(parts[1], o[b]);
                    }
                }
                cache = null;
            }
        },

        /**
         * Utility method for getting the width of the browser scrollbar. This can differ depending on
         * operating system settings, such as the theme or font size.
         * @param {Boolean} force (optional) true to force a recalculation of the value.
         * @return {Number} The width of the scrollbar.
         */
        getScrollBarWidth: function(force){
            if(!OOJS.isReady){
                return 0;
            }

            if(force === true || scrollWidth === null){
                    // Append our div, do our calculation and then remove it
                var div = OOJS.getBody().createChild('<div class="x-hide-offsets" style="width:100px;height:50px;overflow:hidden;"><div style="height:200px;"></div></div>'),
                    child = div.child('div', true);
                var w1 = child.offsetWidth;
                div.setStyle('overflow', (OOJS.isWebKit || OOJS.isGecko) ? 'auto' : 'scroll');
                var w2 = child.offsetWidth;
                div.remove();
                // Need to add 2 to ensure we leave enough space
                scrollWidth = w1 - w2 + 2;
            }
            return scrollWidth;
        },


        // deprecated
        combine : function(){
            var as = arguments, l = as.length, r = [];
            for(var i = 0; i < l; i++){
                var a = as[i];
                if(OOJS.isArray(a)){
                    r = r.concat(a);
                }else if(a.length !== undefined && !a.substr){
                    r = r.concat(Array.prototype.slice.call(a, 0));
                }else{
                    r.push(a);
                }
            }
            return r;
        },

        /**
         * Copies a set of named properties fom the source object to the destination object.
         * <p>example:<pre><code>
ImageComponent = Ext.extend(Ext.BoxComponent, {
    initComponent: function() {
        this.autoEl = { tag: 'img' };
        MyComponent.superclass.initComponent.apply(this, arguments);
        this.initialBox = Ext.copyTo({}, this.initialConfig, 'x,y,width,height');
    }
});
         * </code></pre>
         * @param {Object} dest The destination object.
         * @param {Object} source The source object.
         * @param {Array/String} names Either an Array of property names, or a comma-delimited list
         * of property names to copy.
         * @return {Object} The modified object.
        */
        copyTo : function(dest, source, names){
            if(typeof names == 'string'){
                names = names.split(/[,;\s]/);
            }
            OOJS.each(names, function(name){
                if(source.hasOwnProperty(name)){
                    dest[name] = source[name];
                }
            }, this);
            return dest;
        },

        /**
         * Attempts to destroy any objects passed to it by removing all event listeners, removing them from the
         * DOM (if applicable) and calling their destroy functions (if available).  This method is primarily
         * intended for arguments of type {@link Ext.Element} and {@link Ext.Component}, but any subclass of
         * {@link Ext.util.Observable} can be passed in.  Any number of elements and/or components can be
         * passed into this function in a single call as separate arguments.
         * @param {Mixed...} args An {@link Ext.Element}, {@link Ext.Component}, or an Array of either of these to destroy
         */
        destroy : function(){
            OOJS.each(arguments, function(arg){
                if(arg){
                    if(OOJS.isArray(arg)){
                        this.destroy.apply(this, arg);
                    }else if(typeof arg.destroy == 'function'){
                        arg.destroy();
                    }else if(arg.dom){
                        arg.remove();
                    }
                }
            }, this);
        },

        /**
         * Attempts to destroy and then remove a set of named properties of the passed object.
         * @param {Object} o The object (most likely a Component) who's properties you wish to destroy.
         * @param {Mixed} arg1 The name of the property to destroy and remove from the object.
         * @param {Mixed} etc... More property names to destroy and remove.
         */
        destroyMembers : function(o, arg1, arg2, etc){
            for(var i = 1, a = arguments, len = a.length; i < len; i++) {
                OOJS.destroy(o[a[i]]);
                delete o[a[i]];
            }
        },

        /**
         * Creates a copy of the passed Array with falsy values removed.
         * @param {Array/NodeList} arr The Array from which to remove falsy values.
         * @return {Array} The new, compressed Array.
         */
        clean : function(arr){
            var ret = [];
            OOJS.each(arr, function(v){
                if(!!v){
                    ret.push(v);
                }
            });
            return ret;
        },

        /**
         * Creates a copy of the passed Array, filtered to contain only unique values.
         * @param {Array} arr The Array to filter
         * @return {Array} The new Array containing unique values.
         */
        unique : function(arr){
            var ret = [],
                collect = {};

            OOJS.each(arr, function(v) {
                if(!collect[v]){
                    ret.push(v);
                }
                collect[v] = true;
            });
            return ret;
        },

        /**
         * Recursively flattens into 1-d Array. Injects Arrays inline.
         * @param {Array} arr The array to flatten
         * @return {Array} The new, flattened array.
         */
        flatten : function(arr){
            var worker = [];
            function rFlatten(a) {
                OOJS.each(a, function(v) {
                    if(OOJS.isArray(v)){
                        rFlatten(v);
                    }else{
                        worker.push(v);
                    }
                });
                return worker;
            }
            return rFlatten(arr);
        },

        /**
         * Returns the minimum value in the Array.
         * @param {Array|NodeList} arr The Array from which to select the minimum value.
         * @param {Function} comp (optional) a function to perform the comparision which determines minimization.
         *                   If omitted the "<" operator will be used. Note: gt = 1; eq = 0; lt = -1
         * @return {Object} The minimum value in the Array.
         */
        min : function(arr, comp){
            var ret = arr[0];
            comp = comp || function(a,b){ return a < b ? -1 : 1; };
            OOJS.each(arr, function(v) {
                ret = comp(ret, v) == -1 ? ret : v;
            });
            return ret;
        },

        /**
         * Returns the maximum value in the Array
         * @param {Array|NodeList} arr The Array from which to select the maximum value.
         * @param {Function} comp (optional) a function to perform the comparision which determines maximization.
         *                   If omitted the ">" operator will be used. Note: gt = 1; eq = 0; lt = -1
         * @return {Object} The maximum value in the Array.
         */
        max : function(arr, comp){
            var ret = arr[0];
            comp = comp || function(a,b){ return a > b ? 1 : -1; };
            OOJS.each(arr, function(v) {
                ret = comp(ret, v) == 1 ? ret : v;
            });
            return ret;
        },

        /**
         * Calculates the mean of the Array
         * @param {Array} arr The Array to calculate the mean value of.
         * @return {Number} The mean.
         */
        mean : function(arr){
           return arr.length > 0 ? OOJS.sum(arr) / arr.length : undefined;
        },

        /**
         * Calculates the sum of the Array
         * @param {Array} arr The Array to calculate the sum value of.
         * @return {Number} The sum.
         */
        sum : function(arr){
           var ret = 0;
           OOJS.each(arr, function(v) {
               ret += v;
           });
           return ret;
        },

        /**
         * Partitions the set into two sets: a true set and a false set.
         * Example:
         * Example2:
         * <pre><code>
// Example 1:
Ext.partition([true, false, true, true, false]); // [[true, true, true], [false, false]]

// Example 2:
Ext.partition(
    Ext.query("p"),
    function(val){
        return val.className == "class1"
    }
);
// true are those paragraph elements with a className of "class1",
// false set are those that do not have that className.
         * </code></pre>
         * @param {Array|NodeList} arr The array to partition
         * @param {Function} truth (optional) a function to determine truth.  If this is omitted the element
         *                   itself must be able to be evaluated for its truthfulness.
         * @return {Array} [true<Array>,false<Array>]
         */
        partition : function(arr, truth){
            var ret = [[],[]];
            OOJS.each(arr, function(v, i, a) {
                ret[ (truth && truth(v, i, a)) || (!truth && v) ? 0 : 1].push(v);
            });
            return ret;
        },

        /**
         * Invokes a method on each item in an Array.
         * <pre><code>
// Example:
Ext.invoke(Ext.query("p"), "getAttribute", "id");
// [el1.getAttribute("id"), el2.getAttribute("id"), ..., elN.getAttribute("id")]
         * </code></pre>
         * @param {Array|NodeList} arr The Array of items to invoke the method on.
         * @param {String} methodName The method name to invoke.
         * @param {...*} args Arguments to send into the method invocation.
         * @return {Array} The results of invoking the method on each item in the array.
         */
        invoke : function(arr, methodName){
            var ret = [],
                args = Array.prototype.slice.call(arguments, 2);
            OOJS.each(arr, function(v,i) {
                if (v && typeof v[methodName] == 'function') {
                    ret.push(v[methodName].apply(v, args));
                } else {
                    ret.push(undefined);
                }
            });
            return ret;
        },

        /**
         * Plucks the value of a property from each item in the Array
         * <pre><code>
// Example:
Ext.pluck(Ext.query("p"), "className"); // [el1.className, el2.className, ..., elN.className]
         * </code></pre>
         * @param {Array|NodeList} arr The Array of items to pluck the value from.
         * @param {String} prop The property name to pluck from each element.
         * @return {Array} The value from each item in the Array.
         */
        pluck : function(arr, prop){
            var ret = [];
            OOJS.each(arr, function(v) {
                ret.push( v[prop] );
            });
            return ret;
        },

        /**
         * <p>Zips N sets together.</p>
         * <pre><code>
// Example 1:
Ext.zip([1,2,3],[4,5,6]); // [[1,4],[2,5],[3,6]]
// Example 2:
Ext.zip(
    [ "+", "-", "+"],
    [  12,  10,  22],
    [  43,  15,  96],
    function(a, b, c){
        return "$" + a + "" + b + "." + c
    }
); // ["$+12.43", "$-10.15", "$+22.96"]
         * </code></pre>
         * @param {Arrays|NodeLists} arr This argument may be repeated. Array(s) to contribute values.
         * @param {Function} zipper (optional) The last item in the argument list. This will drive how the items are zipped together.
         * @return {Array} The zipped set.
         */
        zip : function(){
            var parts = OOJS.partition(arguments, function( val ){ return typeof val != 'function'; }),
                arrs = parts[0],
                fn = parts[1][0],
                len = OOJS.max(OOJS.pluck(arrs, "length")),
                ret = [];

            for (var i = 0; i < len; i++) {
                ret[i] = [];
                if(fn){
                    ret[i] = fn.apply(fn, OOJS.pluck(arrs, i));
                }else{
                    for (var j = 0, aLen = arrs.length; j < aLen; j++){
                        ret[i].push( arrs[j][i] );
                    }
                }
            }
            return ret;
        },

        /**
         * This is shorthand reference to {@link Ext.ComponentMgr#get}.
         * Looks up an existing {@link Ext.Component Component} by {@link Ext.Component#id id}
         * @param {String} id The component {@link Ext.Component#id id}
         * @return Ext.Component The Component, <tt>undefined</tt> if not found, or <tt>null</tt> if a
         * Class was found.
        */
        getCmp : function(id){
            return OOJS.ComponentMgr.get(id);
        },

        /**
         * By default, Ext intelligently decides whether floating elements should be shimmed. If you are using flash,
         * you may want to set this to true.
         * @type Boolean
         */
        useShims: E.isIE6 || (E.isMac && E.isGecko2),

        // inpired by a similar function in mootools library
        /**
         * Returns the type of object that is passed in. If the object passed in is null or undefined it
         * return false otherwise it returns one of the following values:<div class="mdetail-params"><ul>
         * <li><b>string</b>: If the object passed is a string</li>
         * <li><b>number</b>: If the object passed is a number</li>
         * <li><b>boolean</b>: If the object passed is a boolean value</li>
         * <li><b>date</b>: If the object passed is a Date object</li>
         * <li><b>function</b>: If the object passed is a function reference</li>
         * <li><b>object</b>: If the object passed is an object</li>
         * <li><b>array</b>: If the object passed is an array</li>
         * <li><b>regexp</b>: If the object passed is a regular expression</li>
         * <li><b>element</b>: If the object passed is a DOM Element</li>
         * <li><b>nodelist</b>: If the object passed is a DOM NodeList</li>
         * <li><b>textnode</b>: If the object passed is a DOM text node and contains something other than whitespace</li>
         * <li><b>whitespace</b>: If the object passed is a DOM text node and contains only whitespace</li>
         * </ul></div>
         * @param {Mixed} object
         * @return {String}
         */
        type : function(o){
            if(o === undefined || o === null){
                return false;
            }
            if(o.htmlElement){
                return 'element';
            }
            var t = typeof o;
            if(t == 'object' && o.nodeName) {
                switch(o.nodeType) {
                    case 1: return 'element';
                    case 3: return (/\S/).test(o.nodeValue) ? 'textnode' : 'whitespace';
                }
            }
            if(t == 'object' || t == 'function') {
                switch(o.constructor) {
                    case Array: return 'array';
                    case RegExp: return 'regexp';
                    case Date: return 'date';
                }
                if(typeof o.length == 'number' && typeof o.item == 'function') {
                    return 'nodelist';
                }
            }
            return t;
        },

        intercept : function(o, name, fn, scope){
            o[name] = o[name].createInterceptor(fn, scope);
        },

        // internal
        callback : function(cb, scope, args, delay){
            if(typeof cb == 'function'){
                if(delay){
                    cb.defer(delay, scope, args || []);
                }else{
                    cb.apply(scope, args || []);
                }
            }
        }
    };
}());

/**
 * @class Function
 * These functions are available on every Function object (any JavaScript function).
 */
OOJS.apply(Function.prototype, {
    /**
     * Create a combined function call sequence of the original function + the passed function.
     * The resulting function returns the results of the original function.
     * The passed fcn is called with the parameters of the original function. Example usage:
     * <pre><code>
var sayHi = function(name){
    alert('Hi, ' + name);
}

sayHi('Fred'); // alerts "Hi, Fred"

var sayGoodbye = sayHi.createSequence(function(name){
    alert('Bye, ' + name);
});

sayGoodbye('Fred'); // both alerts show
</code></pre>
     * @param {Function} fcn The function to sequence
     * @param {Object} scope (optional) The scope (<code><b>this</b></code> reference) in which the passed function is executed.
     * <b>If omitted, defaults to the scope in which the original function is called or the browser window.</b>
     * @return {Function} The new function
     */
    createSequence : function(fcn, scope){
        var method = this;
        return (typeof fcn != 'function') ?
                this :
                function(){
                    var retval = method.apply(this || window, arguments);
                    fcn.apply(scope || this || window, arguments);
                    return retval;
                };
    }
});


/**
 * @class String
 * These functions are available as static methods on the JavaScript String object.
 */
OOJS.applyIf(String, {

    /**
     * Escapes the passed string for ' and \
     * @param {String} string The string to escape
     * @return {String} The escaped string
     * @static
     */
    escape : function(string) {
        return string.replace(/('|\\)/g, "\\$1");
    },

    /**
     * Pads the left side of a string with a specified character.  This is especially useful
     * for normalizing number and date strings.  Example usage:
     * <pre><code>
var s = String.leftPad('123', 5, '0');
// s now contains the string: '00123'
     * </code></pre>
     * @param {String} string The original string
     * @param {Number} size The total length of the output string
     * @param {String} char (optional) The character with which to pad the original string (defaults to empty string " ")
     * @return {String} The padded string
     * @static
     */
    leftPad : function (val, size, ch) {
        var result = String(val);
        if(!ch) {
            ch = " ";
        }
        while (result.length < size) {
            result = ch + result;
        }
        return result;
    }
});

/**
 * Utility function that allows you to easily switch a string between two alternating values.  The passed value
 * is compared to the current string, and if they are equal, the other value that was passed in is returned.  If
 * they are already different, the first value passed in is returned.  Note that this method returns the new value
 * but does not change the current string.
 * <pre><code>
// alternate sort directions
sort = sort.toggle('ASC', 'DESC');

// instead of conditional logic:
sort = (sort == 'ASC' ? 'DESC' : 'ASC');
</code></pre>
 * @param {String} value The value to compare to the current string
 * @param {String} other The new value to use if the string already equals the first value passed in
 * @return {String} The new value
 */
String.prototype.toggle = function(value, other){
    return this == value ? other : value;
};

/**
 * Trims whitespace from either end of a string, leaving spaces within the string intact.  Example:
 * <pre><code>
var s = '  foo bar  ';
alert('-' + s + '-');         //alerts "- foo bar -"
alert('-' + s.trim() + '-');  //alerts "-foo bar-"
</code></pre>
 * @return {String} The trimmed string
 */
String.prototype.trim = function(){
    var re = /^\s+|\s+$/g;
    return function(){ return this.replace(re, ""); };
}();

// here to prevent dependency on Date.js
/**
 Returns the number of milliseconds between this date and date
 @param {Date} date (optional) Defaults to now
 @return {Number} The diff in milliseconds
 @member Date getElapsed
 */
Date.prototype.getElapsed = function(date) {
    return Math.abs((date || new Date()).getTime()-this.getTime());
};


/**
 * @class Number
 */
OOJS.applyIf(Number.prototype, {
    /**
     * Checks whether or not the current number is within a desired range.  If the number is already within the
     * range it is returned, otherwise the min or max value is returned depending on which side of the range is
     * exceeded.  Note that this method returns the constrained value but does not change the current number.
     * @param {Number} min The minimum number in the range
     * @param {Number} max The maximum number in the range
     * @return {Number} The constrained value if outside the range, otherwise the current value
     */
    constrain : function(min, max){
        return Math.min(Math.max(this, min), max);
    }
});





 
/**************
 * Observable *
 **************/

(function(){

	var OOJSUTIL = OOJS.util,
	    EACH = OOJS.each,
	    TRUE = true,
	    FALSE = false;
	/**
	 * @class OOJS.util.Observable
	 * Base class that provides a common interface for publishing events. Subclasses are expected to
	 * to have a property "events" with all the events defined, and, optionally, a property "listeners"
	 * with configured listeners defined.<br>
	 * For example:
	 * <pre><code>
	Employee = OOJS.extend(OOJS.util.Observable, {
	    constructor: function(config){
	        this.name = config.name;
	        this.addEvents({
	            "fired" : true,
	            "quit" : true
	        });

	        // Copy configured listeners into *this* object so that the base class&#39;s
	        // constructor will add them.
	        this.listeners = config.listeners;

	        // Call our superclass constructor to complete construction process.
	        Employee.superclass.constructor.call(this, config)
	    }
	});
	</code></pre>
	 * This could then be used like this:<pre><code>
	var newEmployee = new Employee({
	    name: employeeName,
	    listeners: {
	        quit: function() {
	            // By default, "this" will be the object that fired the event.
	            alert(this.name + " has quit!");
	        }
	    }
	});
	</code></pre>
	 */
	OOJSUTIL.Observable = function(){
	    /**
	     * @cfg {Object} listeners (optional) <p>A config object containing one or more event handlers to be added to this
	     * object during initialization.  This should be a valid listeners config object as specified in the
	     * {@link #addListener} example for attaching multiple handlers at once.</p>
	     * <br><p><b><u>DOM events from ExtJs {@link Ext.Component Components}</u></b></p>
	     * <br><p>While <i>some</i> ExtJs Component classes export selected DOM events (e.g. "click", "mouseover" etc), this
	     * is usually only done when extra value can be added. For example the {@link Ext.DataView DataView}'s
	     * <b><code>{@link Ext.DataView#click click}</code></b> event passing the node clicked on. To access DOM
	     * events directly from a Component's HTMLElement, listeners must be added to the <i>{@link Ext.Component#getEl Element}</i> after the Component
	     * has been rendered. A plugin can simplify this step:<pre><code>
	// Plugin is configured with a listeners config object.
	// The Component is appended to the argument list of all handler functions.
	Ext.DomObserver = Ext.extend(Object, {
	    constructor: function(config) {
	        this.listeners = config.listeners ? config.listeners : config;
	    },

	    // Component passes itself into plugin&#39;s init method
	    init: function(c) {
	        var p, l = this.listeners;
	        for (p in l) {
	            if (Ext.isFunction(l[p])) {
	                l[p] = this.createHandler(l[p], c);
	            } else {
	                l[p].fn = this.createHandler(l[p].fn, c);
	            }
	        }

	        // Add the listeners to the Element immediately following the render call
	        c.render = c.render.{@link Function#createSequence createSequence}(function() {
	            var e = c.getEl();
	            if (e) {
	                e.on(l);
	            }
	        });
	    },

	    createHandler: function(fn, c) {
	        return function(e) {
	            fn.call(this, e, c);
	        };
	    }
	});

	var combo = new Ext.form.ComboBox({

	    // Collapse combo when its element is clicked on
	    plugins: [ new Ext.DomObserver({
	        click: function(evt, comp) {
	            comp.collapse();
	        }
	    })],
	    store: myStore,
	    typeAhead: true,
	    mode: 'local',
	    triggerAction: 'all'
	});
	     * </code></pre></p>
	     */
	    var me = this, e = me.events;
	    if(me.listeners){
	        me.on(me.listeners);
	        delete me.listeners;
	    }
	    me.events = e || {};
	};

	OOJSUTIL.Observable.prototype = {
	    // private
	    filterOptRe : /^(?:scope|delay|buffer|single)$/,

	    /**
	     * <p>Fires the specified event with the passed parameters (minus the event name).</p>
	     * <p>An event may be set to bubble up an Observable parent hierarchy (See {@link Ext.Component#getBubbleTarget})
	     * by calling {@link #enableBubble}.</p>
	     * @param {String} eventName The name of the event to fire.
	     * @param {Object...} args Variable number of parameters are passed to handlers.
	     * @return {Boolean} returns false if any of the handlers return false otherwise it returns true.
	     */
	    fireEvent : function(){
	        var a = Array.prototype.slice.call(arguments, 0),
	            ename = a[0].toLowerCase(),
	            me = this,
	            ret = TRUE,
	            ce = me.events[ename],
	            cc,
	            q,
	            c;
	        if (me.eventsSuspended === TRUE) {
	            if (q = me.eventQueue) {
	                q.push(a);
	            }
	        }
	        else if(typeof ce == 'object') {
	            if (ce.bubble){
	                if(ce.fire.apply(ce, a.slice(1)) === FALSE) {
	                    return FALSE;
	                }
	                c = me.getBubbleTarget && me.getBubbleTarget();
	                if(c && c.enableBubble) {
	                    cc = c.events[ename];
	                    if(!cc || typeof cc != 'object' || !cc.bubble) {
	                        c.enableBubble(ename);
	                    }
	                    return c.fireEvent.apply(c, a);
	                }
	            }
	            else {
	                a.shift();
	                ret = ce.fire.apply(ce, a);
	            }
	        }
	        return ret;
	    },

	    /**
	     * Appends an event handler to this object.
	     * @param {String}   eventName The name of the event to listen for.
	     * @param {Function} handler The method the event invokes.
	     * @param {Object}   scope (optional) The scope (<code><b>this</b></code> reference) in which the handler function is executed.
	     * <b>If omitted, defaults to the object which fired the event.</b>
	     * @param {Object}   options (optional) An object containing handler configuration.
	     * properties. This may contain any of the following properties:<ul>
	     * <li><b>scope</b> : Object<div class="sub-desc">The scope (<code><b>this</b></code> reference) in which the handler function is executed.
	     * <b>If omitted, defaults to the object which fired the event.</b></div></li>
	     * <li><b>delay</b> : Number<div class="sub-desc">The number of milliseconds to delay the invocation of the handler after the event fires.</div></li>
	     * <li><b>single</b> : Boolean<div class="sub-desc">True to add a handler to handle just the next firing of the event, and then remove itself.</div></li>
	     * <li><b>buffer</b> : Number<div class="sub-desc">Causes the handler to be scheduled to run in an {@link Ext.util.DelayedTask} delayed
	     * by the specified number of milliseconds. If the event fires again within that time, the original
	     * handler is <em>not</em> invoked, but the new handler is scheduled in its place.</div></li>
	     * <li><b>target</b> : Observable<div class="sub-desc">Only call the handler if the event was fired on the target Observable, <i>not</i>
	     * if the event was bubbled up from a child Observable.</div></li>
	     * </ul><br>
	     * <p>
	     * <b>Combining Options</b><br>
	     * Using the options argument, it is possible to combine different types of listeners:<br>
	     * <br>
	     * A delayed, one-time listener.
	     * <pre><code>
	myDataView.on('click', this.onClick, this, {
	single: true,
	delay: 100
	});</code></pre>
	     * <p>
	     * <b>Attaching multiple handlers in 1 call</b><br>
	     * The method also allows for a single argument to be passed which is a config object containing properties
	     * which specify multiple handlers.
	     * <p>
	     * <pre><code>
	myGridPanel.on({
	'click' : {
	    fn: this.onClick,
	    scope: this,
	    delay: 100
	},
	'mouseover' : {
	    fn: this.onMouseOver,
	    scope: this
	},
	'mouseout' : {
	    fn: this.onMouseOut,
	    scope: this
	}
	});</code></pre>
	 * <p>
	 * Or a shorthand syntax:<br>
	 * <pre><code>
	myGridPanel.on({
	'click' : this.onClick,
	'mouseover' : this.onMouseOver,
	'mouseout' : this.onMouseOut,
	 scope: this
	});</code></pre>
	     */
	    addListener : function(eventName, fn, scope, o){
	        var me = this,
	            e,
	            oe,
	            ce;
	            
	        if (typeof eventName == 'object') {
	            o = eventName;
	            for (e in o) {
	                oe = o[e];
	                if (!me.filterOptRe.test(e)) {
	                    me.addListener(e, oe.fn || oe, oe.scope || o.scope, oe.fn ? oe : o);
	                }
	            }
	        } else {
	            eventName = eventName.toLowerCase();
	            ce = me.events[eventName] || TRUE;
	            if (typeof ce == 'boolean') {
	                me.events[eventName] = ce = new OOJSUTIL.Event(me, eventName);
	            }
	            ce.addListener(fn, scope, typeof o == 'object' ? o : {});
	        }
	    },

	    /**
	     * Removes an event handler.
	     * @param {String}   eventName The type of event the handler was associated with.
	     * @param {Function} handler   The handler to remove. <b>This must be a reference to the function passed into the {@link #addListener} call.</b>
	     * @param {Object}   scope     (optional) The scope originally specified for the handler.
	     */
	    removeListener : function(eventName, fn, scope){
	        var ce = this.events[eventName.toLowerCase()];
	        if (typeof ce == 'object') {
	            ce.removeListener(fn, scope);
	        }
	    },

	    /**
	     * Removes all listeners for this object
	     */
	    purgeListeners : function(){
	        var events = this.events,
	            evt,
	            key;
	        for(key in events){
	            evt = events[key];
	            if(typeof evt == 'object'){
	                evt.clearListeners();
	            }
	        }
	    },

	    /**
	     * Adds the specified events to the list of events which this Observable may fire.
	     * @param {Object|String} o Either an object with event names as properties with a value of <code>true</code>
	     * or the first event name string if multiple event names are being passed as separate parameters.
	     * @param {string} Optional. Event name if multiple event names are being passed as separate parameters.
	     * Usage:<pre><code>
	this.addEvents('storeloaded', 'storecleared');
	</code></pre>
	     */
	    addEvents : function(o){
	        var me = this;
	        me.events = me.events || {};
	        if (typeof o == 'string') {
	            var a = arguments,
	                i = a.length;
	            while(i--) {
	                me.events[a[i]] = me.events[a[i]] || TRUE;
	            }
	        } else {
	            OOJS.applyIf(me.events, o);
	        }
	    },

	    /**
	     * Checks to see if this object has any listeners for a specified event
	     * @param {String} eventName The name of the event to check for
	     * @return {Boolean} True if the event is being listened for, else false
	     */
	    hasListener : function(eventName){
	        var e = this.events[eventName.toLowerCase()];
	        return typeof e == 'object' && e.listeners.length > 0;
	    },

	    /**
	     * Suspend the firing of all events. (see {@link #resumeEvents})
	     * @param {Boolean} queueSuspended Pass as true to queue up suspended events to be fired
	     * after the {@link #resumeEvents} call instead of discarding all suspended events;
	     */
	    suspendEvents : function(queueSuspended){
	        this.eventsSuspended = TRUE;
	        if(queueSuspended && !this.eventQueue){
	            this.eventQueue = [];
	        }
	    },

	    /**
	     * Resume firing events. (see {@link #suspendEvents})
	     * If events were suspended using the <tt><b>queueSuspended</b></tt> parameter, then all
	     * events fired during event suspension will be sent to any listeners now.
	     */
	    resumeEvents : function(){
	        var me = this,
	            queued = me.eventQueue || [];
	        me.eventsSuspended = FALSE;
	        delete me.eventQueue;
	        EACH(queued, function(e) {
	            me.fireEvent.apply(me, e);
	        });
	    }
	};

	var OBSERVABLE = OOJSUTIL.Observable.prototype;
	/**
	 * Appends an event handler to this object (shorthand for {@link #addListener}.)
	 * @param {String}   eventName     The type of event to listen for
	 * @param {Function} handler       The method the event invokes
	 * @param {Object}   scope         (optional) The scope (<code><b>this</b></code> reference) in which the handler function is executed.
	 * <b>If omitted, defaults to the object which fired the event.</b>
	 * @param {Object}   options       (optional) An object containing handler configuration.
	 * @method
	 */
	OBSERVABLE.on = OBSERVABLE.addListener;
	/**
	 * Removes an event handler (shorthand for {@link #removeListener}.)
	 * @param {String}   eventName     The type of event the handler was associated with.
	 * @param {Function} handler       The handler to remove. <b>This must be a reference to the function passed into the {@link #addListener} call.</b>
	 * @param {Object}   scope         (optional) The scope originally specified for the handler.
	 * @method
	 */
	OBSERVABLE.un = OBSERVABLE.removeListener;

	/**
	 * Removes <b>all</b> added captures from the Observable.
	 * @param {Observable} o The Observable to release
	 * @static
	 */
	OOJSUTIL.Observable.releaseCapture = function(o){
	    o.fireEvent = OBSERVABLE.fireEvent;
	};

	function createTargeted(h, o, scope){
	    return function(){
	        if(o.target == arguments[0]){
	            h.apply(scope, Array.prototype.slice.call(arguments, 0));
	        }
	    };
	};

	function createBuffered(h, o, l, scope){
	    l.task = new OOJSUTIL.DelayedTask();
	    return function(){
	        l.task.delay(o.buffer, h, scope, Array.prototype.slice.call(arguments, 0));
	    };
	};

	function createSingle(h, e, fn, scope){
	    return function(){
	        e.removeListener(fn, scope);
	        return h.apply(scope, arguments);
	    };
	};

	function createDelayed(h, o, l, scope){
	    return function(){
	        var task = new OOJSUTIL.DelayedTask(),
	            args = Array.prototype.slice.call(arguments, 0);
	        if(!l.tasks) {
	            l.tasks = [];
	        }
	        l.tasks.push(task);
	        task.delay(o.delay || 10, function(){
	            l.tasks.remove(task);
	            h.apply(scope, args);
	        }, scope);
	    };
	};

	OOJSUTIL.Event = function(obj, name){
	    this.name = name;
	    this.obj = obj;
	    this.listeners = [];
	};

	OOJSUTIL.Event.prototype = {
	    addListener : function(fn, scope, options){
	        var me = this,
	            l;
	        scope = scope || me.obj;
	        if(!me.isListening(fn, scope)){
	            l = me.createListener(fn, scope, options);
	            if(me.firing){ // if we are currently firing this event, don't disturb the listener loop
	                me.listeners = me.listeners.slice(0);
	            }
	            me.listeners.push(l);
	        }
	    },

	    createListener: function(fn, scope, o){
	        o = o || {};
	        scope = scope || this.obj;
	        var l = {
	            fn: fn,
	            scope: scope,
	            options: o
	        }, h = fn;
	        if(o.target){
	            h = createTargeted(h, o, scope);
	        }
	        if(o.delay){
	            h = createDelayed(h, o, l, scope);
	        }
	        if(o.single){
	            h = createSingle(h, this, fn, scope);
	        }
	        if(o.buffer){
	            h = createBuffered(h, o, l, scope);
	        }
	        l.fireFn = h;
	        return l;
	    },

	    findListener : function(fn, scope){
	        var list = this.listeners,
	            i = list.length,
	            l;

	        scope = scope || this.obj;
	        while(i--){
	            l = list[i];
	            if(l){
	                if(l.fn == fn && l.scope == scope){
	                    return i;
	                }
	            }
	        }
	        return -1;
	    },

	    isListening : function(fn, scope){
	        return this.findListener(fn, scope) != -1;
	    },

	    removeListener : function(fn, scope){
	        var index,
	            l,
	            k,
	            me = this,
	            ret = FALSE;
	        if((index = me.findListener(fn, scope)) != -1){
	            if (me.firing) {
	                me.listeners = me.listeners.slice(0);
	            }
	            l = me.listeners[index];
	            if(l.task) {
	                l.task.cancel();
	                delete l.task;
	            }
	            k = l.tasks && l.tasks.length;
	            if(k) {
	                while(k--) {
	                    l.tasks[k].cancel();
	                }
	                delete l.tasks;
	            }
	            me.listeners.splice(index, 1);
	            ret = TRUE;
	        }
	        return ret;
	    },

	    // Iterate to stop any buffered/delayed events
	    clearListeners : function(){
	        var me = this,
	            l = me.listeners,
	            i = l.length;
	        while(i--) {
	            me.removeListener(l[i].fn, l[i].scope);
	        }
	    },

	    fire : function(){
	        var me = this,
	            listeners = me.listeners,
	            len = listeners.length,
	            i = 0,
	            l;

	        if(len > 0){
	            me.firing = TRUE;
	            var args = Array.prototype.slice.call(arguments, 0);
	            for (; i < len; i++) {
	                l = listeners[i];
	                if(l && l.fireFn.apply(l.scope || me.obj || window, args) === FALSE) {
	                    return (me.firing = FALSE);
	                }
	            }
	        }
	        me.firing = FALSE;
	        return TRUE;
	    }

	};
	})();

/******************
 * OOJS.util.JSON
 ******************/

OOJS.util.JSON = new (function(){
    var useHasOwn = !!{}.hasOwnProperty,
        isNative = function() {
            var useNative = null;

            return function() {
                if (useNative === null) {
                    useNative = OOJS.USE_NATIVE_JSON && window.JSON && JSON.toString() == '[object JSON]';
                }
        
                return useNative;
            };
        }(),
        pad = function(n) {
            return n < 10 ? "0" + n : n;
        },
        doDecode = function(json){
            return json ? eval("(" + json + ")") : "";    
        },
        doEncode = function(o){
            if(!OOJS.isDefined(o) || o === null){
                return "null";
            }else if(OOJS.isArray(o)){
                return encodeArray(o);
            }else if(OOJS.isDate(o)){
                return OOJS.util.JSON.encodeDate(o);
            }else if(OOJS.isString(o)){
                return encodeString(o);
            }else if(typeof o == "number"){
                //don't use isNumber here, since finite checks happen inside isNumber
                return isFinite(o) ? String(o) : "null";
            }else if(OOJS.isBoolean(o)){
                return String(o);
            }else {
                var a = ["{"], b, i, v;
                for (i in o) {
                    // don't encode DOM objects
                    if(!o.getElementsByTagName){
                        if(!useHasOwn || o.hasOwnProperty(i)) {
                            v = o[i];
                            switch (typeof v) {
                            case "undefined":
                            case "function":
                            case "unknown":
                                break;
                            default:
                                if(b){
                                    a.push(',');
                                }
                                a.push(doEncode(i), ":",
                                        v === null ? "null" : doEncode(v));
                                b = true;
                            }
                        }
                    }
                }
                a.push("}");
                return a.join("");
            }    
        },
        m = {
            "\b": '\\b',
            "\t": '\\t',
            "\n": '\\n',
            "\f": '\\f',
            "\r": '\\r',
            '"' : '\\"',
            "\\": '\\\\'
        },
        encodeString = function(s){
            if (/["\\\x00-\x1f]/.test(s)) {
                return '"' + s.replace(/([\x00-\x1f\\"])/g, function(a, b) {
                    var c = m[b];
                    if(c){
                        return c;
                    }
                    c = b.charCodeAt();
                    return "\\u00" +
                        Math.floor(c / 16).toString(16) +
                        (c % 16).toString(16);
                }) + '"';
            }
            return '"' + s + '"';
        },
        encodeArray = function(o){
            var a = ["["], b, i, l = o.length, v;
                for (i = 0; i < l; i += 1) {
                    v = o[i];
                    switch (typeof v) {
                        case "undefined":
                        case "function":
                        case "unknown":
                            break;
                        default:
                            if (b) {
                                a.push(',');
                            }
                            a.push(v === null ? "null" : OOJS.util.JSON.encode(v));
                            b = true;
                    }
                }
                a.push("]");
                return a.join("");
        };

    /**
     * <p>Encodes a Date. This returns the actual string which is inserted into the JSON string as the literal expression.
     * <b>The returned value includes enclosing double quotation marks.</b></p>
     * <p>The default return format is "yyyy-mm-ddThh:mm:ss".</p>
     * <p>To override this:</p><pre><code>
Ext.util.JSON.encodeDate = function(d) {
    return d.format('"Y-m-d"');
};
</code></pre>
     * @param {Date} d The Date to encode
     * @return {String} The string literal to use in a JSON string.
     */
    this.encodeDate = function(o){
        return '"' + o.getFullYear() + "-" +
                pad(o.getMonth() + 1) + "-" +
                pad(o.getDate()) + "T" +
                pad(o.getHours()) + ":" +
                pad(o.getMinutes()) + ":" +
                pad(o.getSeconds()) + '"';
    };

    /**
     * Encodes an Object, Array or other value
     * @param {Mixed} o The variable to encode
     * @return {String} The JSON string
     */
    this.encode = function() {
        var ec;
        return function(o) {
            if (!ec) {
                // setup encoding function on first access
                ec = isNative() ? JSON.stringify : doEncode;
            }
            return ec(o);
        };
    }();


    /**
     * Decodes (parses) a JSON string to an object. If the JSON is invalid, this function throws a SyntaxError unless the safe option is set.
     * @param {String} json The JSON string
     * @return {Object} The resulting object
     */
    this.decode = function() {
        var dc;
        return function(json) {
            if (!dc) {
                // setup decoding function on first access
                dc = isNative() ? JSON.parse : doDecode;
            }
            return dc(json);
        };
    }();

})();
/**
 * Shorthand for {@link Ext.util.JSON#encode}
 * @param {Mixed} o The variable to encode
 * @return {String} The JSON string
 * @member Ext
 * @method encode
 */
OOJS.encode = OOJS.util.JSON.encode;
/**
 * Shorthand for {@link Ext.util.JSON#decode}
 * @param {String} json The JSON string
 * @param {Boolean} safe (optional) Whether to return null or throw an exception if the JSON is invalid.
 * @return {Object} The resulting object
 * @member Ext
 * @method decode
 */
OOJS.decode = OOJS.util.JSON.decode;

/******************
 * OOJS.lib.Ajax
 ******************/

OOJS.lib.Ajax = function() {
    var activeX = ['Msxml2.XMLHTTP.3.0',
                   'Msxml2.XMLHTTP'],
        CONTENTTYPE = 'Content-Type';

    // private
    function setHeader(o) {
        var conn = o.conn,
            prop,
            headers = {};

        function setTheHeaders(conn, headers){
            for (prop in headers) {
                if (headers.hasOwnProperty(prop)) {
                    conn.setRequestHeader(prop, headers[prop]);
                }
            }
        }

        OOJS.apply(headers, pub.headers, pub.defaultHeaders);
        setTheHeaders(conn, headers);
        delete pub.headers;
    }

    // private
    function createExceptionObject(tId, callbackArg, isAbort, isTimeout) {
        return {
            tId : tId,
            status : isAbort ? -1 : 0,
            statusText : isAbort ? 'transaction aborted' : 'communication failure',
            isAbort: isAbort,
            isTimeout: isTimeout,
            argument : callbackArg
        };
    }

    // private
    function initHeader(label, value) {
        (pub.headers = pub.headers || {})[label] = value;
    }

    // private
    function createResponseObject(o, callbackArg) {
        var headerObj = {},
            headerStr,
            conn = o.conn,
            t,
            s,
            // see: https://prototype.lighthouseapp.com/projects/8886/tickets/129-ie-mangles-http-response-status-code-204-to-1223
            isBrokenStatus = conn.status == 1223;

        try {
            headerStr = o.conn.getAllResponseHeaders();
            OOJS.each(headerStr.replace(/\r\n/g, '\n').split('\n'), function(v){
                t = v.indexOf(':');
                if(t >= 0){
                    s = v.substr(0, t).toLowerCase();
                    if(v.charAt(t + 1) == ' '){
                        ++t;
                    }
                    headerObj[s] = v.substr(t + 1);
                }
            });
        } catch(e) {}

        return {
            tId : o.tId,
            // Normalize the status and statusText when IE returns 1223, see the above link.
            status : isBrokenStatus ? 204 : conn.status,
            statusText : isBrokenStatus ? 'No Content' : conn.statusText,
            getResponseHeader : function(header){return headerObj[header.toLowerCase()];},
            getAllResponseHeaders : function(){return headerStr;},
            responseText : conn.responseText,
            responseXML : conn.responseXML,
            argument : callbackArg
        };
    }

    // private
    function releaseObject(o) {
        if (o.tId) {
            pub.conn[o.tId] = null;
        }
        o.conn = null;
        o = null;
    }

    // private
    function handleTransactionResponse(o, callback, isAbort, isTimeout) {
        if (!callback) {
            releaseObject(o);
            return;
        }

        var httpStatus, responseObject;

        try {
            if (o.conn.status !== undefined && o.conn.status != 0) {
                httpStatus = o.conn.status;
            }
            else {
                httpStatus = 13030;
            }
        }
        catch(e) {
            httpStatus = 13030;
        }

        if ((httpStatus >= 200 && httpStatus < 300) || (OOJS.isIE && httpStatus == 1223)) {
            responseObject = createResponseObject(o, callback.argument);
            if (callback.success) {
                if (!callback.scope) {
                    callback.success(responseObject);
                }
                else {
                    callback.success.apply(callback.scope, [responseObject]);
                }
            }
        }
        else {
            switch (httpStatus) {
                case 12002:
                case 12029:
                case 12030:
                case 12031:
                case 12152:
                case 13030:
                    responseObject = createExceptionObject(o.tId, callback.argument, (isAbort ? isAbort : false), isTimeout);
                    if (callback.failure) {
                        if (!callback.scope) {
                            callback.failure(responseObject);
                        }
                        else {
                            callback.failure.apply(callback.scope, [responseObject]);
                        }
                    }
                    break;
                default:
                    responseObject = createResponseObject(o, callback.argument);
                    if (callback.failure) {
                        if (!callback.scope) {
                            callback.failure(responseObject);
                        }
                        else {
                            callback.failure.apply(callback.scope, [responseObject]);
                        }
                    }
            }
        }

        releaseObject(o);
        responseObject = null;
    }
    
    function checkResponse(o, callback, conn, tId, poll, cbTimeout){
        if (conn && conn.readyState == 4) {
            clearInterval(poll[tId]);
            poll[tId] = null;

            if (cbTimeout) {
                clearTimeout(pub.timeout[tId]);
                pub.timeout[tId] = null;
            }
            handleTransactionResponse(o, callback);
        }
    }
    
    function checkTimeout(o, callback){
        pub.abort(o, callback, true);
    }
    

    // private
    function handleReadyState(o, callback){
        callback = callback || {};
        var conn = o.conn,
            tId = o.tId,
            poll = pub.poll,
            cbTimeout = callback.timeout || null;

        if (cbTimeout) {
            pub.conn[tId] = conn;
            pub.timeout[tId] = setTimeout(checkTimeout.createCallback(o, callback), cbTimeout);
        }
        poll[tId] = setInterval(checkResponse.createCallback(o, callback, conn, tId, poll, cbTimeout), pub.pollInterval);
    }

    // private
    function asyncRequest(method, uri, callback, postData) {
        var o = getConnectionObject() || null;

        if (o) {
            o.conn.open(method, uri, true);

            if (pub.useDefaultXhrHeader) {
                initHeader('X-Requested-With', pub.defaultXhrHeader);
            }

            if(postData && pub.useDefaultHeader && (!pub.headers || !pub.headers[CONTENTTYPE])){
                initHeader(CONTENTTYPE, pub.defaultPostHeader);
            }

            if (pub.defaultHeaders || pub.headers) {
                setHeader(o);
            }

            handleReadyState(o, callback);
            o.conn.send(postData || null);
        }
        return o;
    }

    // private
    function getConnectionObject() {
        var o;

        try {
            if (o = createXhrObject(pub.transactionId)) {
                pub.transactionId++;
            }
        } catch(e) {
        } finally {
            return o;
        }
    }

    // private
    function createXhrObject(transactionId) {
        var http;

        try {
            http = new XMLHttpRequest();
        } catch(e) {
            for (var i = OOJS.isIE6 ? 1 : 0; i < activeX.length; ++i) {
                try {
                    http = new ActiveXObject(activeX[i]);
                    break;
                } catch(e) {}
            }
        } finally {
            return {conn : http, tId : transactionId};
        }
    }

    var pub = {
        request : function(method, uri, cb, data, options) {
            if(options){
                var me = this,
                    xmlData = options.xmlData,
                    jsonData = options.jsonData,
                    hs;

                OOJS.applyIf(me, options);

                if(xmlData || jsonData){
                    hs = me.headers;
                    if(!hs || !hs[CONTENTTYPE]){
                        initHeader(CONTENTTYPE, xmlData ? 'text/xml' : 'application/json');
                    }
                    data = xmlData || (!OOJS.isPrimitive(jsonData) ? OOJS.encode(jsonData) : jsonData);
                }
            }
            return asyncRequest(method || options.method || "POST", uri, cb, data);
        },

        serializeForm : function(form) {
            var fElements = form.elements || (document.forms[form] || OOJS.getDom(form)).elements, 
                hasSubmit = false, 
                encoder = encodeURIComponent, 
                name, 
                data = '', 
                type, 
                hasValue;
    
            OOJS.each(fElements, function(element){
                name = element.name;
                type = element.type;
        
                if (!element.disabled && name) {
                    if (/select-(one|multiple)/i.test(type)) {
                        OOJS.each(element.options, function(opt){
                            if (opt.selected) {
                                hasValue = opt.hasAttribute ? opt.hasAttribute('value') : opt.getAttributeNode('value').specified;
                                data += String.format("{0}={1}&", encoder(name), encoder(hasValue ? opt.value : opt.text));
                            }
                        });
                    } else if (!(/file|undefined|reset|button/i.test(type))) {
                        if (!(/radio|checkbox/i.test(type) && !element.checked) && !(type == 'submit' && hasSubmit)) {
                            data += encoder(name) + '=' + encoder(element.value) + '&';
                            hasSubmit = /submit/i.test(type);
                        }
                    }
                }
            });
            return data.substr(0, data.length - 1);
        },

        useDefaultHeader : true,
        defaultPostHeader : 'application/x-www-form-urlencoded; charset=UTF-8',
        useDefaultXhrHeader : true,
        defaultXhrHeader : 'XMLHttpRequest',
        poll : {},
        timeout : {},
        conn: {},
        pollInterval : 50,
        transactionId : 0,

//  This is never called - Is it worth exposing this?
//          setProgId : function(id) {
//              activeX.unshift(id);
//          },

//  This is never called - Is it worth exposing this?
//          setDefaultPostHeader : function(b) {
//              this.useDefaultHeader = b;
//          },

//  This is never called - Is it worth exposing this?
//          setDefaultXhrHeader : function(b) {
//              this.useDefaultXhrHeader = b;
//          },

//  This is never called - Is it worth exposing this?
//          setPollingInterval : function(i) {
//              if (typeof i == 'number' && isFinite(i)) {
//                  this.pollInterval = i;
//              }
//          },

//  This is never called - Is it worth exposing this?
//          resetDefaultHeaders : function() {
//              this.defaultHeaders = null;
//          },

        abort : function(o, callback, isTimeout) {
            var me = this,
                tId = o.tId,
                isAbort = false;

            if (me.isCallInProgress(o)) {
                o.conn.abort();
                clearInterval(me.poll[tId]);
                me.poll[tId] = null;
                clearTimeout(pub.timeout[tId]);
                me.timeout[tId] = null;

                handleTransactionResponse(o, callback, (isAbort = true), isTimeout);
            }
            return isAbort;
        },

        isCallInProgress : function(o) {
            // if there is a connection and readyState is not 0 or 4
            return o.conn && !{0:true,4:true}[o.conn.readyState];
        }
    };
    return pub;
}();


/******************
 * DataConnection *
 ******************/



(function(){
    var BEFOREREQUEST = "beforerequest",
        REQUESTCOMPLETE = "requestcomplete",
        REQUESTEXCEPTION = "requestexception",
        UNDEFINED = undefined,
        LOAD = 'load',
        POST = 'POST',
        GET = 'GET',
        WINDOW = window;

    /**
     * @class Ext.data.Connection
     * @extends Ext.util.Observable
     * <p>The class encapsulates a connection to the page's originating domain, allowing requests to be made
     * either to a configured URL, or to a URL specified at request time.</p>
     * <p>Requests made by this class are asynchronous, and will return immediately. No data from
     * the server will be available to the statement immediately following the {@link #request} call.
     * To process returned data, use a
     * <a href="#request-option-success" ext:member="request-option-success" ext:cls="Ext.data.Connection">success callback</a>
     * in the request options object,
     * or an {@link #requestcomplete event listener}.</p>
     * <p><h3>File Uploads</h3><a href="#request-option-isUpload" ext:member="request-option-isUpload" ext:cls="Ext.data.Connection">File uploads</a> are not performed using normal "Ajax" techniques, that
     * is they are <b>not</b> performed using XMLHttpRequests. Instead the form is submitted in the standard
     * manner with the DOM <tt>&lt;form></tt> element temporarily modified to have its
     * <a href="http://www.w3.org/TR/REC-html40/present/frames.html#adef-target">target</a> set to refer
     * to a dynamically generated, hidden <tt>&lt;iframe></tt> which is inserted into the document
     * but removed after the return data has been gathered.</p>
     * <p>The server response is parsed by the browser to create the document for the IFRAME. If the
     * server is using JSON to send the return object, then the
     * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">Content-Type</a> header
     * must be set to "text/html" in order to tell the browser to insert the text unchanged into the document body.</p>
     * <p>Characters which are significant to an HTML parser must be sent as HTML entities, so encode
     * "&lt;" as "&amp;lt;", "&amp;" as "&amp;amp;" etc.</p>
     * <p>The response text is retrieved from the document, and a fake XMLHttpRequest object
     * is created containing a <tt>responseText</tt> property in order to conform to the
     * requirements of event handlers and callbacks.</p>
     * <p>Be aware that file upload packets are sent with the content type <a href="http://www.faqs.org/rfcs/rfc2388.html">multipart/form</a>
     * and some server technologies (notably JEE) may require some custom processing in order to
     * retrieve parameter names and parameter values from the packet content.</p>
     * <p>Also note that it's not possible to check the response code of the hidden iframe, so the success handler will ALWAYS fire.</p>
     * @constructor
     * @param {Object} config a configuration object.
     */
    OOJS.data.Connection = function(config){
        OOJS.apply(this, config);
        this.addEvents(
            /**
             * @event beforerequest
             * Fires before a network request is made to retrieve a data object.
             * @param {Connection} conn This Connection object.
             * @param {Object} options The options config object passed to the {@link #request} method.
             */
            BEFOREREQUEST,
            /**
             * @event requestcomplete
             * Fires if the request was successfully completed.
             * @param {Connection} conn This Connection object.
             * @param {Object} response The XHR object containing the response data.
             * See <a href="http://www.w3.org/TR/XMLHttpRequest/">The XMLHttpRequest Object</a>
             * for details.
             * @param {Object} options The options config object passed to the {@link #request} method.
             */
            REQUESTCOMPLETE,
            /**
             * @event requestexception
             * Fires if an error HTTP status was returned from the server.
             * See <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec10.html">HTTP Status Code Definitions</a>
             * for details of HTTP status codes.
             * @param {Connection} conn This Connection object.
             * @param {Object} response The XHR object containing the response data.
             * See <a href="http://www.w3.org/TR/XMLHttpRequest/">The XMLHttpRequest Object</a>
             * for details.
             * @param {Object} options The options config object passed to the {@link #request} method.
             */
            REQUESTEXCEPTION
        );
        OOJS.data.Connection.superclass.constructor.call(this);
    };

    OOJS.extend(OOJS.data.Connection, OOJS.util.Observable, {
        /**
         * @cfg {String} url (Optional) <p>The default URL to be used for requests to the server. Defaults to undefined.</p>
         * <p>The <code>url</code> config may be a function which <i>returns</i> the URL to use for the Ajax request. The scope
         * (<code><b>this</b></code> reference) of the function is the <code>scope</code> option passed to the {@link #request} method.</p>
         */
        /**
         * @cfg {Object} extraParams (Optional) An object containing properties which are used as
         * extra parameters to each request made by this object. (defaults to undefined)
         */
        /**
         * @cfg {Object} defaultHeaders (Optional) An object containing request headers which are added
         *  to each request made by this object. (defaults to undefined)
         */
        /**
         * @cfg {String} method (Optional) The default HTTP method to be used for requests.
         * (defaults to undefined; if not set, but {@link #request} params are present, POST will be used;
         * otherwise, GET will be used.)
         */
        /**
         * @cfg {Number} timeout (Optional) The timeout in milliseconds to be used for requests. (defaults to 30000)
         */
        timeout : 30000,
        /**
         * @cfg {Boolean} autoAbort (Optional) Whether this request should abort any pending requests. (defaults to false)
         * @type Boolean
         */
        autoAbort:false,

        /**
         * @cfg {Boolean} disableCaching (Optional) True to add a unique cache-buster param to GET requests. (defaults to true)
         * @type Boolean
         */
        disableCaching: true,

        /**
         * @cfg {String} disableCachingParam (Optional) Change the parameter which is sent went disabling caching
         * through a cache buster. Defaults to '_dc'
         * @type String
         */
        disableCachingParam: '_dc',

        /**
         * <p>Sends an HTTP request to a remote server.</p>
         * <p><b>Important:</b> Ajax server requests are asynchronous, and this call will
         * return before the response has been received. Process any returned data
         * in a callback function.</p>
         * <pre><code>
Ext.Ajax.request({
   url: 'ajax_demo/sample.json',
   success: function(response, opts) {
      var obj = Ext.decode(response.responseText);
      console.dir(obj);
   },
   failure: function(response, opts) {
      console.log('server-side failure with status code ' + response.status);
   }
});
         * </code></pre>
         * <p>To execute a callback function in the correct scope, use the <tt>scope</tt> option.</p>
         * @param {Object} options An object which may contain the following properties:<ul>
         * <li><b>url</b> : String/Function (Optional)<div class="sub-desc">The URL to
         * which to send the request, or a function to call which returns a URL string. The scope of the
         * function is specified by the <tt>scope</tt> option. Defaults to the configured
         * <tt>{@link #url}</tt>.</div></li>
         * <li><b>params</b> : Object/String/Function (Optional)<div class="sub-desc">
         * An object containing properties which are used as parameters to the
         * request, a url encoded string or a function to call to get either. The scope of the function
         * is specified by the <tt>scope</tt> option.</div></li>
         * <li><b>method</b> : String (Optional)<div class="sub-desc">The HTTP method to use
         * for the request. Defaults to the configured method, or if no method was configured,
         * "GET" if no parameters are being sent, and "POST" if parameters are being sent.  Note that
         * the method name is case-sensitive and should be all caps.</div></li>
         * <li><b>callback</b> : Function (Optional)<div class="sub-desc">The
         * function to be called upon receipt of the HTTP response. The callback is
         * called regardless of success or failure and is passed the following
         * parameters:<ul>
         * <li><b>options</b> : Object<div class="sub-desc">The parameter to the request call.</div></li>
         * <li><b>success</b> : Boolean<div class="sub-desc">True if the request succeeded.</div></li>
         * <li><b>response</b> : Object<div class="sub-desc">The XMLHttpRequest object containing the response data.
         * See <a href="http://www.w3.org/TR/XMLHttpRequest/">http://www.w3.org/TR/XMLHttpRequest/</a> for details about
         * accessing elements of the response.</div></li>
         * </ul></div></li>
         * <li><a id="request-option-success"></a><b>success</b> : Function (Optional)<div class="sub-desc">The function
         * to be called upon success of the request. The callback is passed the following
         * parameters:<ul>
         * <li><b>response</b> : Object<div class="sub-desc">The XMLHttpRequest object containing the response data.</div></li>
         * <li><b>options</b> : Object<div class="sub-desc">The parameter to the request call.</div></li>
         * </ul></div></li>
         * <li><b>failure</b> : Function (Optional)<div class="sub-desc">The function
         * to be called upon failure of the request. The callback is passed the
         * following parameters:<ul>
         * <li><b>response</b> : Object<div class="sub-desc">The XMLHttpRequest object containing the response data.</div></li>
         * <li><b>options</b> : Object<div class="sub-desc">The parameter to the request call.</div></li>
         * </ul></div></li>
         * <li><b>scope</b> : Object (Optional)<div class="sub-desc">The scope in
         * which to execute the callbacks: The "this" object for the callback function. If the <tt>url</tt>, or <tt>params</tt> options were
         * specified as functions from which to draw values, then this also serves as the scope for those function calls.
         * Defaults to the browser window.</div></li>
         * <li><b>timeout</b> : Number (Optional)<div class="sub-desc">The timeout in milliseconds to be used for this request. Defaults to 30 seconds.</div></li>
         * <li><b>form</b> : Element/HTMLElement/String (Optional)<div class="sub-desc">The <tt>&lt;form&gt;</tt>
         * Element or the id of the <tt>&lt;form&gt;</tt> to pull parameters from.</div></li>
         * <li><a id="request-option-isUpload"></a><b>isUpload</b> : Boolean (Optional)<div class="sub-desc"><b>Only meaningful when used
         * with the <tt>form</tt> option</b>.
         * <p>True if the form object is a file upload (will be set automatically if the form was
         * configured with <b><tt>enctype</tt></b> "multipart/form-data").</p>
         * <p>File uploads are not performed using normal "Ajax" techniques, that is they are <b>not</b>
         * performed using XMLHttpRequests. Instead the form is submitted in the standard manner with the
         * DOM <tt>&lt;form></tt> element temporarily modified to have its
         * <a href="http://www.w3.org/TR/REC-html40/present/frames.html#adef-target">target</a> set to refer
         * to a dynamically generated, hidden <tt>&lt;iframe></tt> which is inserted into the document
         * but removed after the return data has been gathered.</p>
         * <p>The server response is parsed by the browser to create the document for the IFRAME. If the
         * server is using JSON to send the return object, then the
         * <a href="http://www.w3.org/Protocols/rfc2616/rfc2616-sec14.html#sec14.17">Content-Type</a> header
         * must be set to "text/html" in order to tell the browser to insert the text unchanged into the document body.</p>
         * <p>The response text is retrieved from the document, and a fake XMLHttpRequest object
         * is created containing a <tt>responseText</tt> property in order to conform to the
         * requirements of event handlers and callbacks.</p>
         * <p>Be aware that file upload packets are sent with the content type <a href="http://www.faqs.org/rfcs/rfc2388.html">multipart/form</a>
         * and some server technologies (notably JEE) may require some custom processing in order to
         * retrieve parameter names and parameter values from the packet content.</p>
         * </div></li>
         * <li><b>headers</b> : Object (Optional)<div class="sub-desc">Request
         * headers to set for the request.</div></li>
         * <li><b>xmlData</b> : Object (Optional)<div class="sub-desc">XML document
         * to use for the post. Note: This will be used instead of params for the post
         * data. Any params will be appended to the URL.</div></li>
         * <li><b>jsonData</b> : Object/String (Optional)<div class="sub-desc">JSON
         * data to use as the post. Note: This will be used instead of params for the post
         * data. Any params will be appended to the URL.</div></li>
         * <li><b>disableCaching</b> : Boolean (Optional)<div class="sub-desc">True
         * to add a unique cache-buster param to GET requests.</div></li>
         * </ul></p>
         * <p>The options object may also contain any other property which might be needed to perform
         * postprocessing in a callback because it is passed to callback functions.</p>
         * @return {Number} transactionId The id of the server transaction. This may be used
         * to cancel the request.
         */
        request : function(o){
            var me = this;
            if(me.fireEvent(BEFOREREQUEST, me, o)){
                if (o.el) {
                    if(!OOJS.isEmpty(o.indicatorText)){
                        me.indicatorText = '<div class="loading-indicator">'+o.indicatorText+"</div>";
                    }
                    if(me.indicatorText) {
                        OOJS.getDom(o.el).innerHTML = me.indicatorText;
                    }
                    o.success = (OOJS.isFunction(o.success) ? o.success : function(){}).createInterceptor(function(response) {
                        OOJS.getDom(o.el).innerHTML = response.responseText;
                    });
                }

                var p = o.params,
                    url = o.url || me.url,
                    method,
                    cb = {success: me.handleResponse,
                          failure: me.handleFailure,
                          scope: me,
                          argument: {options: o},
                          timeout : OOJS.num(o.timeout, me.timeout)
                    },
                    form,
                    serForm;


                if (OOJS.isFunction(p)) {
                    p = p.call(o.scope||WINDOW, o);
                }

                p = OOJS.urlEncode(me.extraParams, OOJS.isObject(p) ? OOJS.urlEncode(p) : p);

                if (OOJS.isFunction(url)) {
                    url = url.call(o.scope || WINDOW, o);
                }

                if((form = OOJS.getDom(o.form))){
                    url = url || form.action;
                     if(o.isUpload || (/multipart\/form-data/i.test(form.getAttribute("enctype")))) {
                         return me.doFormUpload.call(me, o, p, url);
                     }
                    serForm = OOJS.lib.Ajax.serializeForm(form);
                    p = p ? (p + '&' + serForm) : serForm;
                }

                method = o.method || me.method || ((p || o.xmlData || o.jsonData) ? POST : GET);

                if(method === GET && (me.disableCaching && o.disableCaching !== false) || o.disableCaching === true){
                    var dcp = o.disableCachingParam || me.disableCachingParam;
                    url = OOJS.urlAppend(url, dcp + '=' + (new Date().getTime()));
                }

                o.headers = OOJS.applyIf(o.headers || {}, me.defaultHeaders || {});

                if(o.autoAbort === true || me.autoAbort) {
                    me.abort();
                }

                if((method == GET || o.xmlData || o.jsonData) && p){
                    url = OOJS.urlAppend(url, p);
                    p = '';
                }
                return (me.transId = OOJS.lib.Ajax.request(method, url, cb, p, o));
            }else{
                return o.callback ? o.callback.apply(o.scope, [o,UNDEFINED,UNDEFINED]) : null;
            }
        },

        /**
         * Determine whether this object has a request outstanding.
         * @param {Number} transactionId (Optional) defaults to the last transaction
         * @return {Boolean} True if there is an outstanding request.
         */
        isLoading : function(transId){
            return transId ? OOJS.lib.Ajax.isCallInProgress(transId) : !! this.transId;
        },

        /**
         * Aborts any outstanding request.
         * @param {Number} transactionId (Optional) defaults to the last transaction
         */
        abort : function(transId){
            if(transId || this.isLoading()){
                OOJS.lib.Ajax.abort(transId || this.transId);
            }
        },

        // private
        handleResponse : function(response){
            this.transId = false;
            var options = response.argument.options;
            response.argument = options ? options.argument : null;
            this.fireEvent(REQUESTCOMPLETE, this, response, options);
            if(options.success){
                options.success.call(options.scope, response, options);
            }
            if(options.callback){
                options.callback.call(options.scope, options, true, response);
            }
        },

        // private
        handleFailure : function(response, e){
            this.transId = false;
            var options = response.argument.options;
            response.argument = options ? options.argument : null;
            this.fireEvent(REQUESTEXCEPTION, this, response, options, e);
            if(options.failure){
                options.failure.call(options.scope, response, options);
            }
            if(options.callback){
                options.callback.call(options.scope, options, false, response);
            }
        },

        // private
        doFormUpload : function(o, ps, url){
            var id = OOJS.id(),
                doc = document,
                frame = doc.createElement('iframe'),
                form = OOJS.getDom(o.form),
                hiddens = [],
                hd,
                encoding = 'multipart/form-data',
                buf = {
                    target: form.target,
                    method: form.method,
                    encoding: form.encoding,
                    enctype: form.enctype,
                    action: form.action
                };

            /*
             * Originally this behaviour was modified for Opera 10 to apply the secure URL after
             * the frame had been added to the document. It seems this has since been corrected in
             * Opera so the behaviour has been reverted, the URL will be set before being added.
             */
            OOJS.fly(frame).set({
                id: id,
                name: id,
                cls: 'x-hidden',
                src: OOJS.SSL_SECURE_URL
            }); 

            doc.body.appendChild(frame);

            // This is required so that IE doesn't pop the response up in a new window.
            if(OOJS.isIE){
               document.frames[id].name = id;
            }


            OOJS.fly(form).set({
                target: id,
                method: POST,
                enctype: encoding,
                encoding: encoding,
                action: url || buf.action
            });

            // add dynamic params
            OOJS.iterate(OOJS.urlDecode(ps, false), function(k, v){
                hd = doc.createElement('input');
                OOJS.fly(hd).set({
                    type: 'hidden',
                    value: v,
                    name: k
                });
                form.appendChild(hd);
                hiddens.push(hd);
            });

            function cb(){
                var me = this,
                    // bogus response object
                    r = {responseText : '',
                         responseXML : null,
                         argument : o.argument},
                    doc,
                    firstChild;

                try{
                    doc = frame.contentWindow.document || frame.contentDocument || WINDOW.frames[id].document;
                    if(doc){
                        if(doc.body){
                            if(/textarea/i.test((firstChild = doc.body.firstChild || {}).tagName)){ // json response wrapped in textarea
                                r.responseText = firstChild.value;
                            }else{
                                r.responseText = doc.body.innerHTML;
                            }
                        }
                        //in IE the document may still have a body even if returns XML.
                        r.responseXML = doc.XMLDocument || doc;
                    }
                }
                catch(e) {}

                OOJS.EventManager.removeListener(frame, LOAD, cb, me);

                me.fireEvent(REQUESTCOMPLETE, me, r, o);

                function runCallback(fn, scope, args){
                    if(OOJS.isFunction(fn)){
                        fn.apply(scope, args);
                    }
                }

                runCallback(o.success, o.scope, [r, o]);
                runCallback(o.callback, o.scope, [o, true, r]);

                if(!me.debugUploads){
                    setTimeout(function(){OOJS.removeNode(frame);}, 100);
                }
            }

            OOJS.EventManager.on(frame, LOAD, cb, this);
            form.submit();

            OOJS.fly(form).set(buf);
            OOJS.each(hiddens, function(h) {
                OOJS.removeNode(h);
            });
        }
    });
})();

/**
 * @class Ext.Ajax
 * @extends Ext.data.Connection
 * <p>The global Ajax request class that provides a simple way to make Ajax requests
 * with maximum flexibility.</p>
 * <p>Since Ext.Ajax is a singleton, you can set common properties/events for it once
 * and override them at the request function level only if necessary.</p>
 * <p>Common <b>Properties</b> you may want to set are:<div class="mdetail-params"><ul>
 * <li><b><tt>{@link #method}</tt></b><p class="sub-desc"></p></li>
 * <li><b><tt>{@link #extraParams}</tt></b><p class="sub-desc"></p></li>
 * <li><b><tt>{@link #url}</tt></b><p class="sub-desc"></p></li>
 * </ul></div>
 * <pre><code>
// Default headers to pass in every request
Ext.Ajax.defaultHeaders = {
    'Powered-By': 'Ext'
};
 * </code></pre>
 * </p>
 * <p>Common <b>Events</b> you may want to set are:<div class="mdetail-params"><ul>
 * <li><b><tt>{@link Ext.data.Connection#beforerequest beforerequest}</tt></b><p class="sub-desc"></p></li>
 * <li><b><tt>{@link Ext.data.Connection#requestcomplete requestcomplete}</tt></b><p class="sub-desc"></p></li>
 * <li><b><tt>{@link Ext.data.Connection#requestexception requestexception}</tt></b><p class="sub-desc"></p></li>
 * </ul></div>
 * <pre><code>
// Example: show a spinner during all Ajax requests
Ext.Ajax.on('beforerequest', this.showSpinner, this);
Ext.Ajax.on('requestcomplete', this.hideSpinner, this);
Ext.Ajax.on('requestexception', this.hideSpinner, this);
 * </code></pre>
 * </p>
 * <p>An example request:</p>
 * <pre><code>
// Basic request
Ext.Ajax.{@link Ext.data.Connection#request request}({
   url: 'foo.php',
   success: someFn,
   failure: otherFn,
   headers: {
       'my-header': 'foo'
   },
   params: { foo: 'bar' }
});

// Simple ajax form submission
Ext.Ajax.{@link Ext.data.Connection#request request}({
    form: 'some-form',
    params: 'foo=bar'
});
 * </code></pre>
 * </p>
 * @singleton
 */
OOJS.Ajax = new OOJS.data.Connection({
    /**
     * @cfg {String} url @hide
     */
    /**
     * @cfg {Object} extraParams @hide
     */
    /**
     * @cfg {Object} defaultHeaders @hide
     */
    /**
     * @cfg {String} method (Optional) @hide
     */
    /**
     * @cfg {Number} timeout (Optional) @hide
     */
    /**
     * @cfg {Boolean} autoAbort (Optional) @hide
     */

    /**
     * @cfg {Boolean} disableCaching (Optional) @hide
     */

    /**
     * @property  disableCaching
     * True to add a unique cache-buster param to GET requests. (defaults to true)
     * @type Boolean
     */
    /**
     * @property  url
     * The default URL to be used for requests to the server. (defaults to undefined)
     * If the server receives all requests through one URL, setting this once is easier than
     * entering it on every request.
     * @type String
     */
    /**
     * @property  extraParams
     * An object containing properties which are used as extra parameters to each request made
     * by this object (defaults to undefined). Session information and other data that you need
     * to pass with each request are commonly put here.
     * @type Object
     */
    /**
     * @property  defaultHeaders
     * An object containing request headers which are added to each request made by this object
     * (defaults to undefined).
     * @type Object
     */
    /**
     * @property  method
     * The default HTTP method to be used for requests. Note that this is case-sensitive and
     * should be all caps (defaults to undefined; if not set but params are present will use
     * <tt>"POST"</tt>, otherwise will use <tt>"GET"</tt>.)
     * @type String
     */
    /**
     * @property  timeout
     * The timeout in milliseconds to be used for requests. (defaults to 30000)
     * @type Number
     */

    /**
     * @property  autoAbort
     * Whether a new request should abort any pending requests. (defaults to false)
     * @type Boolean
     */
    autoAbort : false,

    /**
     * Serialize the passed form into a url encoded string
     * @param {String/HTMLElement} form
     * @return {String}
     */
    serializeForm : function(form){
        return OOJS.lib.Ajax.serializeForm(form);
    }
});

