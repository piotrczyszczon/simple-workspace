module library.impl.provider {
  requires library.impl;
  provides com.github.piotrczyszczon.simpleworkspace.modularity.library.Office with com.github.piotrczyszczon.simpleworkspace.modularity.library.impl.OfficeImpl;
}