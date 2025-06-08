#!/usr/bin/env bash
set -e

# Tests Backend
cd backend
mvn test

# Tests Frontend
cd ../frontend
npm run test -- --watchAll=false
