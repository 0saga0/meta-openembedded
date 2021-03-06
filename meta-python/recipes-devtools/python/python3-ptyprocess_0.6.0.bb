SUMMARY = "Run a subprocess in a pseudo terminal"
HOMEPAGE = "http://ptyprocess.readthedocs.io/en/latest/"
SECTION = "devel/python"
LICENSE = "ISC"
LIC_FILES_CHKSUM = "file://LICENSE;md5=cfdcd51fa7d5808da4e74346ee394490"

SRCNAME = "ptyprocess"

SRC_URI[md5sum] = "37402d69f3b50913d4d483587bffad8f"
SRC_URI[sha256sum] = "923f299cc5ad920c68f2bc0bc98b75b9f838b93b599941a6b63ddbc2476394c0"

inherit pypi setuptools3

UPSTREAM_CHECK_URI = "https://pypi.python.org/pypi/ptyprocess"

S = "${WORKDIR}/${SRCNAME}-${PV}"

RDEPENDS_${PN} = "\
    ${PYTHON_PN}-core \
    ${PYTHON_PN}-fcntl \
    ${PYTHON_PN}-terminal \
    ${PYTHON_PN}-resource \
"

BBCLASSEXTEND = "native nativesdk"

inherit ptest

SRC_URI += " \
	file://run-ptest \
"

RDEPENDS_${PN}-ptest += " \
	${PYTHON_PN}-pytest \
	${PYTHON_PN}-fcntl \
	${PYTHON_PN}-terminal \
	${PYTHON_PN}-resource \
"

do_install_ptest() {
	install -d ${D}${PTEST_PATH}/tests
	cp -rf ${S}/tests/* ${D}${PTEST_PATH}/tests/
}
